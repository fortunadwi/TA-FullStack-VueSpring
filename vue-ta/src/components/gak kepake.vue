<template>
  <div>
    <h2 class="mt-5">Tambah Anggota Keluarga</h2>
    <router-link to="/Home"><button class="btn btn-primary mt-3">Back</button></router-link>
    <router-link to="/AddAnggotaKK"><button class="btn btn-danger mt-3 ml-3">Tambah Anggota Keluarga</button></router-link>

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
              <router-link
                :to="{ name: 'detailanggotakk', params: { id: item.id } }"
                @click.prevent="$emit('updateAnggotaKK, item')"
              >
                <button class="btn-primary">Details</button></router-link
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
</template>

<script>
import AnggotaKKService from "../services/AnggotaKKService";

export default {
  name: "ContentComp",
  methods: {
    getAnggotaKK() {
      AnggotaKKService
        .getAll()
        .then((response) => {
          this.anggotaData = response.data;
          console.log(this.kkData);
        })
        .catch((e) => {
          console.log(e);
        });
    },

    deleteAnggotaKK(id, index) {
      if (confirm("Apakah anda yakin hapus?")) {
        AnggotaKKService
          .deleteKK(id)
          .then((response) => {
            console.log(response.data);
            this.anggotaData.splice(index, 1);
          })
          .catch((e) => {
            console.log(e);
          });
      } else {
        this.alert("Hapus Dibatalkan");
      }
    },
  },
  mounted() {
    this.getAnggotaKK();
  },
  data() {
    return {
      anggotaData: null,
    };
  },
};
</script>

<style></style>
