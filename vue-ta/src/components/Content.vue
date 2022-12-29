<template>
  <div>
    <h2 class="mt-5">HomePage</h2>

    <!-- Card -->
    <div class="d-flex">
      <div class="card mt-4" style="width: 25rem; border-radius: 20px">
        <div class="card-body bg-light">
          <h3 class="card-title">Jumlah Kartu Keluarga</h3>
          <hr />
          <!-- <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6> -->
          <h2 class="card-text">{{ kkData.length }}</h2>
        </div>
      </div>
      <div class="card mt-4 ml-5" style="width: 33rem; border-radius: 20px">
        <div class="card-body bg-light">
          <h3 class="card-title">Jumlah Seluruh Anggota Keluarga</h3>
          <hr />
          <!-- <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6> -->
          <h2 class="card-text">{{ AnggotaKKData.length }}</h2>
        </div>
      </div>
    </div>

    <div class="mt-5">
      <table class="table table-hover">
        <thead>
          <tr class="table-primary">
            <th scope="col">No</th>
            <th scope="col">Nomor KK</th>
            <th scope="col">Alamat</th>
            <th scope="col">Kota</th>
            <th scope="col">Kode Pos</th>
            <th scope="col">Action</th>
          </tr>
        </thead>

        <tbody>
          <tr v-for="(item, index) in kkData" :key="item.id">
            <!-- <th scope="row">1</th> -->
            <th>{{ index + 1 }}</th>
            <td>{{ item.nomor_kk }}</td>
            <td>{{ item.alamat }}</td>
            <td>{{ item.kabupaten_kota }}</td>
            <td>{{ item.kode_pos }}</td>
            <!-- <td>@click.prevent="$emit('updateKK, item')"</td> -->
            <td>
              <router-link :to="{ name: 'detailkk', params: { id: item.id } }">
                <button class="btn-primary">Details</button></router-link
              >
              <button class="btn-danger ml-3" @click="deleteKK(item.id)">
                Delete
              </button>
            </td>
          </tr>
        </tbody>
      </table>
      <h2 class="text-center" v-if="kkData.length < 1">Tidak Ada Data</h2>
    </div>
  </div>
</template>

<script>
import kkServices from "../services/KkServices";
import AnggotakkServices from "../services/AnggotaKKService";
import Swal from "sweetalert2";

export default {
  name: "ContentComp",
  methods: {
    getKK() {
      kkServices
        .getAll()
        .then((response) => {
          this.kkData = response.data;
          console.log(this.kkData);
        })
        .catch((e) => {
          console.log(e);
        });
    },

    getAnggota() {
      AnggotakkServices.getAll()
        .then((response) => {
          this.AnggotaKKData = response.data;
          console.log(this.AnggotaKKData);
        })
        .catch((e) => {
          console.log(e);
        });
    },

    deleteKK(id) {
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

            kkServices.deleteKK(id).then((response) => {
            console.log(response.data);

            AnggotakkServices.deleteIdKK(id).then((response) => {
            console.log(response.data);
            });
            location.reload();
            // this.kkData.splice(index, 1);
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
  mounted() {
    this.getKK();
    this.getAnggota();
  },
  data() {
    return {
      kkData: "",
      AnggotaKKData: "",
    };
    
  },
};
</script>

<style></style>
