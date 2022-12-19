<template>
  <div class="d-flex">
      
      <SideBar></SideBar>
      <FormAnggotaKK></FormAnggotaKK>
      <!-- <Footer></Footer> -->
  </div>
</template>

<script>

import SideBar from '../components/SideBar.vue'
import FormAnggotaKK from '../components/FormAnggotaKK.vue'
// import Footer from '../components/Footer.vue'

export default {
    name: 'HomePage',
    components: {
        
        SideBar,
        FormAnggotaKK,
        // Footer,
        
    }
}
</script>

<style>

</style>