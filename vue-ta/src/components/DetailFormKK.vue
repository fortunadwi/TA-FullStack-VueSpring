<template>
  <div>
      <div class="">
        <h2 class="mt-5">Detail Kartu Keluarga</h2>
      </div>
      <div class="mt-5">
        <router-link to="/Home"><button class="btn btn-primary">Back</button></router-link>
        <router-link to="/Home"><button class="btn btn-secondary ml-3">Update Kartu Keluarga</button></router-link>
        <router-link to="/Home"><button class="btn btn-danger ml-3">Lihat Anggota Keluarga</button></router-link>
      </div>
      
    <div class="mt-5">
    <div class="border border-secondary p-4" style="border-radius:2%; margin-left: 6em" >
      
    <form @submit.prevent="inputKK" class="d-flex">
      <div id="kiri" class="ml-2">
        <div class="form-group col p-3">
          <label for="">Nomor Kartu Keluarga</label>
          <input type="text" style="width:25em" readonly class="form-control" placeholder="{{}}">
        </div>
        <div class="form-group col mt-5">
          <label for="">Alamat</label>
          <textarea class="form-control p-4" readonly placeholder="Alamat"></textarea>
        </div>
        <div class="form-group col mt-5">
          <label for="">RT</label>
          <input type="text" class="form-control" readonly placeholder="RT">
        </div>
        <div class="form-group col mt-5">
          <label for="">RW</label>
          <input type="text" class="form-control" readonly placeholder="RW">
        </div>
      </div>


      <div id="kanan" class="ml-5">
        <div class="form-group col p-3">
          <label for="">Desa / Kelurahan</label>
          <input type="text" style="width:25em" class="form-control" readonly placeholder="Desa / Kelurahan">
        </div>
        <div class="form-group col mt-5">
          <label for="">Kecamatan</label>
          <input type="text" class="form-control" readonly placeholder="Kecamatan">
        </div>
        <div class="form-group col">
          <label for="">Kabupaten / Kota</label>
          <input type="text" class="form-control" readonly placeholder="Kabupaten / Kota">
        </div>
        <div class="form-group col mt-5">
          <label for="">Provinsi</label>
          <input type="text" class="form-control" readonly placeholder="Provinsi">
        </div>
        <div class="form-group col mt-5">
          <label for="">Kode Pos</label>
          <input type="text" class="form-control" readonly placeholder="Kode Pos">
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
};
</script>

<style>

</style>