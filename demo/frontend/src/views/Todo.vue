<template>
<!-- 컴포넌트 -->
  <div class="todo">
    <todo-header></todo-header>
    <todo-input v-on:addTodo="onAddTodo"></todo-input>
    <todo-filter></todo-filter>
    <todo-list v-on:removeTodo="onRemoveTodo"
      v-on:updateTodo="onEditTodo"
      v-on:toggleTodoStatus="onToggleTodoStatus"></todo-list>
    <todo-footer v-on:removeAll="onClearAll"></todo-footer>
    <b>random: {{ this.$store.getters.random }}</b><br>
    <input type="button" @click="randomNumber()" value="random"/><br>
  </div>
</template>

<script>
import TodoHeader from '../components/TodoHeader.vue'
import TodoInput from '../components/TodoInput.vue'
import TodoList from '../components/TodoList.vue'
import TodoFooter from '../components/TodoFooter.vue'
import TodoFilter from '../components/TodoFilter.vue'
import { mapActions } from 'vuex'
//  import store from '../store'
//  State와 Actions를 자동으로 추가해
export default {
  name: 'Todo',
  components: {
    'todo-header': TodoHeader,
    'todo-input': TodoInput,
    'todo-list': TodoList,
    'todo-footer': TodoFooter,
    'todo-filter': TodoFilter
  },
  //  data () {
  //    return {
  //      todoItems: []
  //    }
  //  },
  methods: {
    ...mapActions([
      'clearAll',
      'addTodo',
      'removeTodo',
      'generateRandomNumber',
      'save',
      'restore',
      'editTodo',
      'toggleTodoStatus'
    ]),
    onClearAll () {
      this.clearAll()
      this.save()
    },
    onAddTodo (content) {
      const todoItem = { content }

      this.addTodo(todoItem)
      this.save()
    },
    onRemoveTodo (id) {
      this.removeTodo(id)
      this.save()
    },
    randomNumber () {
      // this.$store.dispatch('generateRandomNumber')
      this.generateRandomNumber()
    },
    onEditTodo (content, id) {
      this.editTodo({ id, content })
      this.save()
    },
    onToggleTodoStatus (id) {
      this.toggleTodoStatus(id)
      this.save()
    }
  },
  created () {
    this.restore()
  }
}
</script>

<style>
  body {
    text-align: center;
    background-color: #894987;
  }
</style>
    //  clearAll () {
    //    this.todoItems = []
    //    store.dispatch('clearAll')
    //  },
    //  addTodo (todoItem) {
    //    this.todoItems.push(todoItem)
    //    store.dispatch('addTodo', todoItem)
    //  },
    //  removeTodo (todoItem, idx) {
    //    this.todoItems.splice(idx, 1)
    //  store.dispatch('removeTodo', idx)
    //  }
    //  },
    //  자동계산 하기 위함, 너무 많은 데이터는 안됨
    //  computed: {
    //  ...mapState([
    //  'todoItems'
    //  ])
    //  todoItems () {
    //    return store.state.todoItems
    //  }
    //  }
    //  }
