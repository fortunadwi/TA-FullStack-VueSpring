<template>
  <div>
    <h2 class="mt-5">HomePage</h2>

    <!-- Card -->
    <div class="d-flex">
      <div class="card mt-4" style="width: 25rem; border-radius: 20px">
        <div class="card-body">
          <h3 class="card-title">Jumlah Kartu Keluarga</h3>
          <hr />
          <!-- <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6> -->
          <h2 class="card-text">{{ kkData.length }}</h2>
        </div>
      </div>
      <div class="card mt-4 ml-5" style="width: 25rem; border-radius: 20px">
        <div class="card-body">
          <h3 class="card-title">Jumlah Seluruh Warga</h3>
          <hr />
          <!-- <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6> -->
          <p class="card-text">Some quick example text to build on the card</p>
        </div>
      </div>
    </div>

    <div class="mt-5">
      <table class="table table-hover">
        <thead>
          <tr>
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
              <button class="btn-danger ml-3" @click="deleteKK(item.id, index)">
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
import kkServices from "../services/KkServices";

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

    deleteKK(id, index) {
      if (confirm("Apakah anda yakin hapus?")) {
        kkServices
          .deleteKK(id)
          .then((response) => {
            console.log(response.data);
            this.kkData.splice(index, 1);
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
    this.getKK();
  },
  data() {
    return {
      kkData: null,
    };
  },
};
</script>

<style></style>
