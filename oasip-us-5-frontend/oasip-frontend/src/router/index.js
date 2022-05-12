import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import Create from '../views/Create.vue'
import AboutUs from '../views/AboutUs.vue'

const history = createWebHistory(import.meta.env.BASE_URL)
const routes = [
  { path: '/', name: 'Home', component: Home },
  { path: '/home', redirect: '/' },
  { path: '/create', name: 'Create', component: Create },
  { path: '/about-us', name: 'AboutUs', component: AboutUs },
]

const router = createRouter({ history, routes })
export default router
