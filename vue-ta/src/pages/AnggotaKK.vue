<template>
  <div class="d-flex">
    <SideBar></SideBar>
    <FormAnggotaKK></FormAnggotaKK>
  </div>
</template>

<script>
import SideBar from "../components/SideBar.vue";
import FormAnggotaKK from "../components/FormAnggotaKK.vue";

export default {
  name: "HomePage",
  components: {
    SideBar,
    FormAnggotaKK,
  },
  data() {
    return {
      AnggotaKKData: null,
    };
  },
  methods: {
    updateAnggotaKKFunc(item) {
      this.AnggotaKKData = item;
    },
  },
};
</script>

<style></style>
