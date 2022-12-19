<template>
  <div>
    <div class="">
      <h2 class="mt-5">{{ title }}</h2>
    </div>
    <div class="mt-5">
      <router-link to="/Home"><button class="btn btn-primary">Back</button></router-link>
      <button
        v-show="UpdateButton"
        v-on:click="buttonUpdate"
        class="btn btn-secondary ml-3"
      >
        Update Kartu Keluarga
      </button>
      <router-link :to="{ name: 'detailanggotakk' }"
        ><button v-show="ListButton" class="btn btn-danger ml-3">
          Lihat Anggota Keluarga
        </button></router-link
      >
    </div>

    <div class="mt-5">
      <div
        class="border border-secondary p-4"
        style="border-radius: 2%; margin-left: 6em"
      >
        <form @submit.prevent="inputKK" class="d-flex">
          <div id="kiri" class="ml-2">
            <div class="form-group col p-3">
              <label for="">Nomor Kartu Keluarga</label>
              <input
                v-model="kkData.nomor_kk"
                type="number"
                style="width: 25em"
                class="form-control"
                placeholder="Nomor Kartu Keluarga"
                :disabled="ReadonlyKK"
              />
            </div>
            <div class="form-group col mt-5">
              <label for="">Alamat</label>
              <textarea
                v-model="kkData.alamat"
                class="form-control p-4"
                placeholder="Alamat"
                :disabled="ReadonlyKK"
              ></textarea>
            </div>
            <div class="form-group col mt-5">
              <label for="">RT</label>
              <input
                v-model="kkData.rt"
                type="number"
                class="form-control"
                placeholder="RT"
                :disabled="ReadonlyKK"
              />
            </div>
            <div class="form-group col mt-5">
              <label for="">RW</label>
              <input
                v-model="kkData.rw"
                type="number"
                class="form-control"
                placeholder="RW"
                :disabled="ReadonlyKK"
              />
            </div>
          </div>

          <div id="kanan" class="ml-5">
            <div class="form-group col p-3">
              <label for="">Desa / Kelurahan</label>
              <input
                v-model="kkData.desa_kelurahan"
                type="text"
                style="width: 25em"
                class="form-control"
                placeholder="Desa / Kelurahan"
                :disabled="ReadonlyKK"
              />
            </div>
            <div class="form-group col mt-5">
              <label for="">Kecamatan</label>
              <input
                v-model="kkData.kecamatan"
                type="text"
                class="form-control"
                placeholder="Kecamatan"
                :disabled="ReadonlyKK"
              />
            </div>
            <div class="form-group col">
              <label for="">Kabupaten / Kota</label>
              <input
                v-model="kkData.kabupaten_kota"
                type="text"
                class="form-control"
                placeholder="Kabupaten / Kota"
                :disabled="ReadonlyKK"
              />
            </div>
            <div class="form-group col mt-5">
              <label for="">Provinsi</label>
              <input
                v-model="kkData.provinsi"
                type="text"
                class="form-control"
                :disabled="ReadonlyKK"
                placeholder="Provinsi"
              />
            </div>
            <div class="form-group col mt-5">
              <label for="">Kode Pos</label>
              <input
                v-model="kkData.kode_pos"
                type="number"
                class="form-control"
                placeholder="Kode Po"
                :disabled="ReadonlyKK"
              />
            </div>
            <div style="margin-left: 21.3em">
              <button
                v-show="SubmitButton"
                type="submit"
                id="submitdata"
                class="btn btn-primary mt-4 mr-2"
              >
                {{ buttonValue }}
              </button>
              <button
                v-on:click="CancelUpdate"
                v-show="CancelButton"
                type="button"
                id="submitdata"
                class="btn btn-danger mt-4"
              >
                Cancel
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
import kkServices from "../services/KkServices";
import Swal from "sweetalert2";

export default {
  name: "FormKKComponent",
  data() {
    return {
      kkData: {
        alamat: null,
        desa_kelurahan: null,
        kabupaten_kota: null,
        kecamatan: null,
        kode_pos: null,
        nomor_kk: null,
        provinsi: null,
        rt: null,
        rw: null,
      },
      success: false,
      buttonValue: "Submit",
      title: "Tambah Kartu Keluarga",
      ReadonlyKK: true,
      UpdateButton: false,
      ListButton: false,
      SubmitButton: true,
    };
  },

  methods: {
    inputKK() {
      let data = this.kkData;
      if (this.buttonValue === "Submit") {
        kkServices.create(data).then((response) => {
          console.log(response.data);
          this.success = true;
        });
        Swal.fire({
          position: "center",
          icon: "success",
          title: "Registerasi Berhasil! Silahkan Login",
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
        kkServices.updateKK(data.id, data).then((response) => {
          console.log(response.data);
          this.success = true;
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
    selectIdKartuKeluarga(id) {
      kkServices.selectIdKK(id).then((response) => {
        this.kkData = response.data;
      });
    },

    buttonUpdate() {
      this.ReadonlyKK = false;
      this.buttonValue = "Update";

      this.SubmitButton = true;
      this.CancelButton = true;
    },

    CancelUpdate() {
      this.ReadonlyKK = true;
      this.CancelButton = false;
      this.SubmitButton = false;
    },
  },

  props: ["propsKK"],
  mounted() {
    if (this.$route.name == "detailkk") {
      this.selectIdKartuKeluarga(this.$route.params.id);
      this.title = "Update Kartu Keluarga";
      this.UpdateButton = true;
      this.ListButton = true;
      this.SubmitButton = false;
    } else if (this.title == "Tambah Kartu Keluarga") {
      this.ReadonlyKK = false;
    }
  },
};
</script>

<style></style>
