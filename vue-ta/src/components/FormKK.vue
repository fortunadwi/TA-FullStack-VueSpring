<template>
  <div>
      <div class="">
        <h2 class="mt-5">Tambah Kartu Keluarga</h2>
      </div>
      <div class="mt-5">
        <router-link to="/Home"><button class="btn btn-primary">Back</button></router-link>
      </div>

    <div class="mt-5">
    <div class="border border-secondary p-4" style="border-radius:2%; margin-left: 6em" >
      
    <form @submit.prevent="inputKK" class="d-flex">
      <div id="kiri" class="ml-2">
        <div class="form-group col p-3">
          <label for="">Nomor Kartu Keluarga</label>
          <input v-model="kkData.nomor_kk" type="text" style="width:25em"  class="form-control" placeholder="Nomor Kartu Keluarga">
        </div>
        <div class="form-group col mt-5">
          <label for="">Alamat</label>
          <textarea v-model="kkData.alamat" class="form-control p-4" placeholder="Alamat"></textarea>
        </div>
        <div class="form-group col mt-5">
          <label for="">RT</label>
          <input v-model="kkData.rt" type="text" class="form-control" placeholder="RT">
        </div>
        <div class="form-group col mt-5">
          <label for="">RW</label>
          <input v-model="kkData.rw" type="text" class="form-control" placeholder="RW">
        </div>
      </div>


      <div id="kanan" class="ml-5">
        <div class="form-group col p-3">
          <label for="">Desa / Kelurahan</label>
          <input v-model="kkData.desa_kelurahan" type="text" style="width:25em" class="form-control" placeholder="Desa / Kelurahan">
        </div>
        <div class="form-group col mt-5">
          <label for="">Kecamatan</label>
          <input v-model="kkData.kecamatan" type="text" class="form-control" placeholder="Kecamatan">
        </div>
        <div class="form-group col">
          <label for="">Kabupaten / Kota</label>
          <input v-model="kkData.kabupaten_kota" type="text" class="form-control" placeholder="Kabupaten / Kota">
        </div>
        <div class="form-group col mt-5">
          <label for="">Provinsi</label>
          <input v-model="kkData.provinsi" type="text" class="form-control" placeholder="Provinsi">
        </div>
        <div class="form-group col mt-5">
          <label for="">Kode Pos</label>
          <input v-model="kkData.kode_pos" type="text" class="form-control" placeholder="Kode Po">
        </div>
        <div style="margin-left:21.3em">
          
					<button type="submit" id="submitdata" class="btn btn-primary mt-4">
              Submit
            </button>
        </div>
				
      </div> 

    </form>
    
    </div>
    </div>
    <div style="margin-top:10%">
        <hr style="width:135%">
        <h5 class="p-3" style=" margin-left:13em"> 
            Copyright 2022 • All Rights Reserved LuxSpace Fortuna Dwi</h5>
    </div>

  </div>
</template>

<script>
import kkServices from '../services/KkServices'
import Swal from 'sweetalert2'

export default {
  name: "FormKKComponent",
  data(){
    return{
      kkData: {
        "alamat" : null,
        "desa_kelurahan" : null,
        "kabupaten_kota" : null,
        "kecamatan" : null,
        "kode_pos" : null,
        "nomor_kk" : null,
        "provinsi" : null,
        "rt" : null,
        "rw" : null
      },
      success : false,
      buttonValue : "Submit"
    }
  },

  methods : {
    inputKK() {
      let data = this.kkData;
      if(this.buttonValue === "Submit") {
        kkServices.create(data)
        .then(response => {
          console.log(response.data);
          this.success = true;
        });
        Swal.fire({
          position: 'center',
          icon: 'success',
          title: 'Registerasi Berhasil! Silahkan Login',
          timer: 2000,
          timerProgressBar:true,
          }).then(()=>{
          this.$router.push("/Home")
          // .catch(() => {
          //     this.$router.push("/")
        })
        .catch(e => {
          console.log(e);
        })
      } 
      // else {
      //   kkServices.updateKK(
      //     data.id, data)
      //     .then(response => {
      //       console.log(response.data);
      //       this.success = true;
      //     })
      //     .catch(e => {
      //       console.log(e);
      //     });
        
      // }
    },
  },

  // props: ["kkDataProps"],
  // watch: {
  //   'kkDataProps'(newValue) {
  //     this.kkData = newValue;
  //     console.log(this.kkData);
  //     this.buttonValue = "Update"
  //   }
  // }
  
};
</script>

<style></style>
