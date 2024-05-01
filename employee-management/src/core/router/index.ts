import HomeView from "@/core/views/HomeView.vue";
import AboutView from "@/core/views/AboutView.vue";
import AddEmployeeView from "@/core/views/AddEmployeeView.vue";
import ShowView from "@/core/views/ShowView.vue"
import EditEmployeeView from "@/core/views/EditEmployeeView.vue"
import {createRouter, createWebHistory} from "vue-router";

const routes = [
    {
        path: "/",
        name: "home",
        component: HomeView,
    },
    {
        path: "/about",
        name: "about",
        component: AboutView
    },
    {
        path: "/add/employee",
        name: "add",
        component: AddEmployeeView
    }, {
        path: "/details/employee/:id",
        name: "details",
        component: ShowView
    }, {
        path: "/edit/employee/:id",
        name: "edit",
        component: EditEmployeeView
    }

]


const router = createRouter({
    routes,
    history: createWebHistory(process.env.BASE_URL)
})


export default router;
