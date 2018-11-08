// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
//import router from './router'
import routers from './routers'
import VueRouter from 'vue-router'

Vue.config.productionTip = false

var axios = require('axios')
axios.defaults.baseURL = 'https://localhost:8080/demospotify'
Vue.prototype.$axios = axios
Vue.config.productionTip = false

Vue.use(VueRouter)
const router = new VueRouter({
  mode: 'history',
  routes: routers
})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
