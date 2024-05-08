
import {createRouter, createWebHistory,RouteRecordRaw} from "vue-router";

const rootRoute =  { path: '/', redirect: 'login' };

const  routeOptions = [
    {path: '/login',name:'Login'},
    {path: '/home',name: 'Home'},
    {path: '/about',name: 'About'},
    {path: "/add/employee",name: "AddEmployee" },
    {path: "/details/employee/:id",name: "Show"},
    {path: "/edit/employee/:id",name: "EditEmployee"}
];

let routes:Array<RouteRecordRaw>  = routeOptions.map((route)=>{
    return {
        ...route,
        component:()=> import(`../views/${route.name}View.vue`)
    }
})

routes = [ rootRoute , ...routes ];

const router = createRouter({
    routes,
    history: createWebHistory(process.env.BASE_URL)
})


export default router;



// const routes = [
//     {
//         path: "/",
//         name: "home",
//         component: HomeView,
//     },
//     {
//         path: "/about",
//         name: "about",
//         component: AboutView
//     },
//     {
//         path: "/add/employee",
//         name: "add",
//         component: AddEmployeeView
//     }, {
//         path: "/details/employee/:id",
//         name: "details",
//         component: ShowView
//     }, {
//         path: "/edit/employee/:id",
//         name: "edit",
//         component: EditEmployeeView
//     },
//     {
//         path: "/login",
//         name: "login" ,
//         component: LoginView
//     }
//
// ]



