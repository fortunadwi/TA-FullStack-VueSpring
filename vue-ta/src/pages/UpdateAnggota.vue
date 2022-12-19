<template>
  <div class="d-flex">
    <Sidebar></Sidebar>
    <FormAnggota></FormAnggota>
  </div>
</template>

<script>
import Sidebar from "../components/SideBar.vue";
import FormAnggota from "../components/FormAnggotaKK.vue";
export default {
  name: "UpdateAnggotaComp",
  components: {
    Sidebar,
    FormAnggota,
  },
};
</script>

<style></style>
