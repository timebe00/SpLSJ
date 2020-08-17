import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import cookies from 'vue-cookies'

Vue.config.productionTip = false

Vue.use(cookies)

function init () {
  const savedToken = cookies.get('accessToken')

  if (savedToken) {
    return store.dispatch('loginByToken', savedToken)
  } else {
  //  Promise는 비동기 처리
  //  오류 있다고해도 없는 것 처럼 사용
    return Promise.resolve()
  }
}

init().then(() => {
  new Vue({
    router,
    store,
    render: h => h(App)
  }).$mount('#app')
})
