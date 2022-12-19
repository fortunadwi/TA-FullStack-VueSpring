
import LoginRegister from "./pages/LoginRegis.vue"
import HomePage from './pages/Home.vue'
import FormKK from './pages/AddKK.vue'
import DetailKK from './pages/DetailKK.vue'
import AnggotaKK from './pages/AnggotaKK.vue'
import AddAnggotaKK from './pages/AddAnggotaKK.vue'
import UpdateAnggota from './pages/UpdateAnggota'

export default [
    {
    path: "/",
    component: LoginRegister,
    },

    {
        path: "/Home",
        component: HomePage,
    },

    {
        path: "/AddKK",
        component: FormKK,
    },

    {
        path: "/DetailKK/:id",
        name: "detailkk",
        component: DetailKK,
    },

    {
        path: "/DetailKK/:id/AnggotaKK",
        name: "detailanggotakk",
        component: AnggotaKK,
    },

    {
        path: "/AddAnggotaKK",
        component: AddAnggotaKK,
    },
   
    {
        path: "/:id/AnggotaKK/:ida",
        name: "detailanggotakka",
        component: UpdateAnggota,
    },
    
];
