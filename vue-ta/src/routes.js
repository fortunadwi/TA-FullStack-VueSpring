
import LoginRegister from "./pages/LoginRegis.vue"
import HomePage from './pages/Home.vue'
import FormKK from './pages/AddKK.vue'
import DetailKK from './pages/DetailKK.vue'

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
        path: "/DetailKK",
        component: DetailKK,
    },

    
];
