<template>
  <div>
    <div class="">
      <h2 class="mt-5">Daftar Anggota Keluarga</h2>
    </div>
    <div class="mt-5">
      <router-link :to="{ name: 'detailanggotakk' }"
        ><button v-show="BackShow" v-on:click="BackButton" class="btn btn-primary">
          Back
        </button></router-link
      >

      <router-link :to="{ name: 'detailkk' }"
        ><button v-show="BackShow2" class="btn btn-primary">Back</button></router-link
      >

      <button v-show="AddShow" v-on:click="buttonAdd" class="btn btn-success ml-3">
        {{ titleValue }}
      </button>
    </div>

    <div v-show="tableShow">
      <div class="mt-5">
        <table class="table table-hover">
          <thead>
            <tr>
              <th scope="col">No</th>
              <th scope="col">NIK</th>
              <th scope="col">Nama</th>
              <th scope="col">Jenis Kelamin</th>
              <th scope="col">Kepala Keluarga</th>
              <th scope="col">Action</th>
            </tr>
          </thead>

          <tbody>
            <tr v-for="(item, index) in anggotaData" :key="item.id">
              <th>{{ index + 1 }}</th>
              <td>{{ item.nik }}</td>
              <td>{{ item.nama }}</td>
              <td>{{ item.jenis_kelamin }}</td>
              <td>{{ item.kepala_keluarga }}</td>
              <td>
                <router-link :to="{ name: 'detailanggotakka', params: { ida: item.id } }">
                  <button v-on:click="DetailButton" class="btn-primary">
                    Details
                  </button></router-link
                >
                <button class="btn-danger ml-3" @click="deleteAnggotaKK(item.id, index)">
                  Delete
                </button>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>

    <div class="mt-5" v-show="formShow">
      <div
        class="border border-secondary p-4"
        style="border-radius: 2%; margin-left: 6em"
      >
        <form @submit.prevent="inputAnggotaKK" class="d-flex">
          <div id="kiri" class="ml-2">
            <div class="form-group col p-3">
              <label for="">NIK</label>
              <input
                :disabled="ReadonlyAnggota"
                v-model="AnggotaKKData.nik"
                type="text"
                style="width: 25em"
                class="form-control"
                placeholder="NIK"
                value=""
              />
            </div>
            <div class="form-group col mt-5">
              <label for="">Nama</label>
              <input
                :disabled="ReadonlyAnggota"
                v-model="AnggotaKKData.nama"
                type="text"
                class="form-control"
                placeholder="Nama"
              />
            </div>
            <div class="form-group col mt-5">
              <label for="">Jenis Kelamin</label>
              <select
                :disabled="ReadonlyAnggota"
                v-model="AnggotaKKData.jenis_kelamin"
                class="form-control"
              >
                <option selected></option>
                <option>Pria</option>
                <option>Wanita</option>
              </select>
            </div>
            <div class="form-group col mt-5">
              <label for="">Tempat Lahir</label>
              <input
                :disabled="ReadonlyAnggota"
                v-model="AnggotaKKData.tempat_lahir"
                type="text"
                class="form-control"
                placeholder="Tempat Lahir"
              />
            </div>
          </div>

          <div id="kanan" class="ml-5">
            <div class="form-group col p-3">
              <label for="">Tanggal Lahir</label>
              <input
                v-model="AnggotaKKData.tanggal_lahir"
                type="date"
                style="width: 25em"
                class="form-control"
                placeholder="Tanggal Lahir"
                :disabled="ReadonlyAnggota"
              />
            </div>
            <div class="form-group col mt-5">
              <label for="">Agama</label>
              <input
                v-model="AnggotaKKData.agama"
                type="text"
                class="form-control"
                placeholder="Agama"
                :disabled="ReadonlyAnggota"
              />
            </div>
            <div class="form-group col mt-5">
              <label for="">Pendididkan</label>
              <input
                v-model="AnggotaKKData.pendidikan"
                type="text"
                class="form-control"
                placeholder="Pendididkan"
                :disabled="ReadonlyAnggota"
              />
            </div>
            <div class="form-group col mt-5">
              <label for="">Kepala Keluarga</label>
              <select
                :disabled="ReadonlyAnggota"
                v-model="AnggotaKKData.kepala_keluarga"
                class="form-control"
              >
                <option selected></option>
                <option>Pria</option>
                <option>Wanita</option>
              </select>
            </div>
            <div>
              <button
                v-on:click="SubmitIdKk"
                type="submit"
                class="btn btn-primary mt-4 mr-2"
              >
                {{ buttonValue }}
              </button>
            </div>
          </div>
        </form>
      </div>
    </div>
    <div style="margin-top: 10%">
      <hr style="width: 135%" />
      <h5 class="p-3" style="margin-left: 13em">
        Copyright 2022 • All Rights Reserved LuxSpace Fortuna Dwi
      </h5>
    </div>
  </div>
</template>

<script>
import AnggotaKKServices from "../services/AnggotaKKService";
import Swal from "sweetalert2";

export default {
  name: "AnggotaKKComponent",
  data() {
    return {
      AnggotaKKData: {
        agama: null,
        id_kk: null,
        jenis_kelamin: null,
        kepala_keluarga: null,
        nama: null,
        nik: null,
        pendidikan: null,
        tanggal_lahir: null,
        tempat_lahir: null,
      },

      buttonValue: "Submit",
      titleValue: "Tambah Anggota Keluarga",
      ReadonlyAnggota: false,
      anggotaData: null,
      formShow: false,
      AddShow: true,
      tableShow: true,
      BackShow: false,
      BackShow2: true,
    };
  },

  methods: {
    inputAnggotaKK() {
      let data = this.AnggotaKKData;
      if (this.buttonValue === "Submit") {
        AnggotaKKServices.create(data).then((response) => {
          console.log(response.data);
        });
        Swal.fire({
          position: "center",
          icon: "success",
          title: "Pendaftaran Anggota Berhasil !",
          timer: 2000,
          timerProgressBar: true,
        })
          .then(() => {
            this.$router.push("/Home");
            // .catch(() => {
            //     this.$router.push("/")
          })
          .catch((e) => {
            console.log(e);
          });
      } else {
        AnggotaKKServices.updateAnggotaKK(data.id, data).then((response) => {
          console.log(response.data);
        });
        Swal.fire({
          position: "center",
          icon: "success",
          title: "Update Data Berhasil !",
          // timer: 2000,
          timerProgressBar: false,
        })
          .then(() => {
            this.$router.push("/Home");
            // .catch(() => {
            //     this.$router.push("/")
          })
          .catch((e) => {
            console.log(e);
          });
      }
    },
    selectIdAnggota(id) {
      AnggotaKKServices.selectIdAnggotaKK(id).then((response) => {
        this.AnggotaKKData = response.data;
      });
    },

    buttonAdd() {
      this.formShow = true;
      this.tableShow = false;
      this.UpdateShow = false;
      this.BackShow = true;
      this.BackShow2 = false;
      this.AddShow = false;
      this.ReadonlyAnggota = false;
    },

    BackButton() {
      this.formShow = false;
      this.tableShow = true;
      this.UpdateShow = true;
      this.titleValue = "Tambah Anggota Keluarga";
      this.AddShow = true;
      this.BackShow = false;
      this.BackShow2 = true;
    },

    DetailButton() {
      this.formShow = true;
      this.tableShow = false;
      this.BackShow = true;
      this.titleValue = "Update Anggota";
      this.BackShow2 = false;
      this.ReadonlyAnggota = true;
    },

    selectIdAnggota2(id) {
      AnggotaKKServices.selectIdAnggotaKK(id).then((response) => {
        this.AnggotaKKData = response.data;
        console.log(this.AnggotaKKData);
      });
    },

    getByIdKk(id_kk) {
      AnggotaKKServices.getAnggotaIdKk(id_kk)
        .then((response) => {
          this.anggotaData = response.data;
          console.log(this.AnggotaKKData);
        })
        .catch((e) => {
          console.log(e);
        });
    },

    SubmitIdKk() {
      this.AnggotaKKData.id_kk = this.$route.params.id;
    },

    deleteAnggotaKK(id, index) {
      const swalWithBootstrapButtons = Swal.mixin({
        customClass: {
          confirmButton: "btn btn-success m-3",
          cancelButton: "btn btn-danger",
        },
        buttonsStyling: false,
      });

      swalWithBootstrapButtons
        .fire({
          title: "Apakah Anda Yakin Ingin Hapus Data Ini?",
          text: "Kamu Tidak Bisa Mengembalikan Data Jika Sudah Terhapus",
          icon: "warning",
          showCancelButton: true,
          confirmButtonText: "Ya, Hapus Data!",
          cancelButtonText: "Tidak, Kembali",
          reverseButtons: true,
        })
        .then((result) => {
          if (result.isConfirmed) {
            AnggotaKKServices.deleteKK(id)
              .then((response) => {
                console.log(response.data);
                this.anggotaData.splice(index, 1);
              })
              .catch((e) => {
                console.log(e);
              });
            swalWithBootstrapButtons.fire(
              "Data Terhapus!",
              "Data Anda Berhasil Dihapus",
              "success"
            );
          } else if (
            /* Read more about handling dismissals below */
            result.dismiss === Swal.DismissReason.cancel
          ) {
            swalWithBootstrapButtons.fire(
              "Dibatalkan",
              "Tidak Ada Perubahan :)",
              "error"
            );
          }
        });
    },
  },

  props: ["propsAnggotaKK"],
  mounted() {
    this.getByIdKk(this.$route.params.id);
    if (this.$route.name == "detailanggotakka") {
      this.selectIdAnggota2(this.$route.params.ida);
      this.buttonValue = "Update";
      // this.selectIdAnggota(this.$route.params.id);
      console.log("ok");
    } else if (this.titleValue == "Update Anggota") {
      this.ReadonlyAnggota = false;
    }
  },
};
</script>

<style></style>
