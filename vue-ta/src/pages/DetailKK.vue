<template>
  <div class="d-flex">
      
      <SideBar></SideBar>
      <DetailFormKK></DetailFormKK>
      <!-- <Footer></Footer> -->
  </div>
</template>

<script>

import SideBar from '../components/SideBar.vue'
import DetailFormKK from '../components/DetailFormKK.vue'
// import Footer from '../components/Footer.vue'

export default {
    name: 'HomePage',
    components: {
        
        SideBar,
        DetailFormKK,
        // Footer,
        
    }
}
</script>

<style>

</style>