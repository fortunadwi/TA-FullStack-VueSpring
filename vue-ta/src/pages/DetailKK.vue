<template>
  <div class="d-flex">
    <SideBar></SideBar>
    <FormKK :propsKK="kkData"></FormKK>
    <Content v-show="none" @updateKK="updateKKFunc"></Content>
    <!-- <Footer></Footer> -->
  </div>
</template>

<script>
import SideBar from "../components/SideBar.vue";
import FormKK from "../components/FormKK.vue";
import Content from "../components/Content.vue";
// import Footer from '../components/Footer.vue'

export default {
  name: "HomePage",
  components: {
    SideBar,
    FormKK,
    Content,
    // Footer,
  },
  data() {
    return {
      kkData: null,
    };
  },
  methods: {
    updateKKFunc(item) {
      this.kkData = item;
    },
  },
};
</script>

<style></style>
