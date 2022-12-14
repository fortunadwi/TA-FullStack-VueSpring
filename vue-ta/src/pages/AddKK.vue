<template>
  <div class="d-flex">
      
      <SideBar></SideBar>
      <FormKK></FormKK>
      <!-- <Footer></Footer> -->
  </div>
</template>

<script>

import SideBar from '../components/SideBar.vue'
import FormKK from '../components/FormKK.vue'
// import Footer from '../components/Footer.vue'

export default {
    name: 'HomePage',
    components: {
        
        SideBar,
        FormKK,
        // Footer,
        
    }
}
</script>

<style>

</style>