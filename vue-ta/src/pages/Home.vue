<template>
  <div class="d-flex" >
      <!-- <NavBar></NavBar> -->
      <SideBar></SideBar>
      <Content></Content>
  </div>
</template>

<script>
// import NavBar from '../components/NavBar.vue'
import SideBar from '../components/SideBar.vue'
import Content from '../components/Content.vue'

export default {
    name: 'HomePage',
    components: {
        // NavBar,
        SideBar,
        Content,
    }
}
</script>

<style>

</style>