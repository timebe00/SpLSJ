<template>
  <div class="home">
    <div id="header">
      <router-link :to="{ name: 'Home' }" class="nav-link" active-class="active">
        Home
      </router-link>
      <router-link :to="{ name: 'About'}" class="nav-link" active-class="active">
      About Us
      </router-link>
      <router-link :to="{ name: 'Test'}" class="nav-link" active-class="active">
        Test
      </router-link>
    </div>
    <h2>This is an Test Page</h2>
    <div id="app">
      <p v-if="seen">You can see it!</p>
      <p v-bind:key=todo v-for="todo in todos">
        {{ todo.text }}
      </p>
      <p>{{ message }}</p>
      <button v-on:click="reverseMsg">Reverse Message</button>
      <p>{{ message }}</p>
      <input v-model="message"><br/>
      <button @click="incCnt">{{ cnt }}</button><br>
      <!-- border-collapse는 테두리와 셀 사이 간격 삭제 -->

      <p>count 기반 순회</p>
      <table border="1" style="border-collapse:collapse;">
        <tr v-bind:key=idx v-for="idx in count">
          <td>{{ msg }}</td>
          <td>{{ idx }}</td>
        </tr>
      </table>

      <p>list() 기반 순화</p>
      <table border="1" style="border-collapse:collapse;">
        <tr v-bind:key=idx v-for="idx in list()">
          <td>{{ message }}</td>
          <td>{{ idx }}</td>
        </tr>
      </table>

      <p>(key, value) 기반 순화</p>
      <table border="1" style="border-collapse:collapse;">
        <tr v-bind:key="(key, value)" v-for="(key, value) in data">
          <td>{{ key }}</td>
          <td>{{ value }}</td>
        </tr>
      </table>
      <!-- this.$store가 결국  Vuex를 사용하겠다는 의미 -->
      <b>count: {{ this.$store.state.count }}</b><br>
      <b>count^2: {{ this.$store.getters.count }}</b><br>
      <b>weight: {{ this.$store.getters.weight }}</b><br>
      <input type="button" @click="increment()" value="inc"/>
      <input type="button" @click="decrement()" value="dec"/><br>
      <b>random: {{ this.$store.getters.random }}</b><br>
      <input type="button" @click="randomNumber()" value="random"/><br>

      <global-component v-bind:initial-counter="counter">
      </global-component><br>
      <abc v-bind:cka="counter"></abc><br>
      <local-component v-bind:num="value"></local-component>
      <button v-on:click="plus">Click</button><br>
    </div>
  </div>
</template>

<script>
import Vue from 'vue'
import cookies from 'vue-cookies'
/* eslint-disable no-unused-vars */
import store from '../store'
import GlobalComponent from '../components/GlobalComponent.vue'
import ABC from '../components/ABC.vue'
import LocalComponent from '../components/LocalComponent.vue'

Vue.component(GlobalComponent.name, GlobalComponent)
Vue.component(ABC.name, ABC)

Vue.use(cookies)

export default {
  components: {
    'local-component': LocalComponent
  },
  data: function () {
    return {
      counter: 3,
      msg: 'Test',
      value: 0,
      count: 7,
      list: function () {
        var list = []
        for (var i = 1; i < this.count; i += 2) {
          list.push(i)
        }
        return list
      },
      message: 'Test Page',
      seen: true,
      todos: [
        { text: 'JavaScript' },
        { text: 'Golang' },
        { text: 'C++' }
      ],
      cnt: 0,
      data: {
        bird: 'raven',
        animal: 'tiger',
        fish: 'tuna',
        proj: 'cnn',
        major: 'EE'
      }
    }
  },
  methods: {
    reverseMsg: function () {
      this.message = this.message.split('').reverse().join('')
    },
    incCnt: function () {
      this.cnt++
    },
    increment: function () {
      this.$store.commit('increment')
      this.$cookies.set('value', this.$store.state.count)
    },
    decrement: function () {
      this.$store.commit('decrement')
      this.$cookies.set('value', this.$store.state.count)
    },
    randomNumber: function () {
      //  dispatch는 무족건 action으로 간다.
      //  commit는 무족건 비동기 처리가 가능하다.
      //  generateRandomNumber 서버에 랜덤 보내달라고 요청한다.
      this.$store.dispatch('generateRandomNumber')
    },
    plus: function () {
      this.value++
    }
  },
  created: function () {
    this.$store.state.count = this.$cookies.get('value')
  }
}
</script>
