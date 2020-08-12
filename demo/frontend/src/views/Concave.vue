<template>
  <div class="concave">
    <div>{{ turn }}님의 턴입니다.</div>
    <p>O 누른 수 : {{ Ocounter }}<p>
    <p>X 누른 수 : {{ Xcounter }}<p>
    <table-component :table-data="tableData"
        v-bind:turn="turn"
        v-bind:winner="winner"
        v-on:updateTurn="updateTurn"
        v-on:updateTableData="updateTableData"
        v-on:updateWinner="updateWinner">
    </table-component>
    <br>
    <div v-if="winner">{{ winner }}님의 승리!</div>
  </div>
</template>

<script>
import TableComponent from '../components/TableComponent.vue'

export default {
  components: {
    TableComponent
  },
  data () {
    return {
      turn: 'O',
      winner: '',
      tableData: [
        ['', '', ''],
        ['', '', ''],
        ['', '', '']
      ],
      Ocounter: 0,
      Xcounter: 0
    }
  },
  update: function () {
    console.log('tableData: ' + this.tableData + ', turn: ' + this.turn + ', winner' + this.winner)
  },
  methods: {
    updateTurn: function (val) {
      console.log('Concave updateTurn: ' + val)
      this.turn = val
    },
    updateTableData: function () {
      this.tableData = [
        ['', '', ''],
        ['', '', ''],
        ['', '', '']
      ]
    },
    updateWinner: function (val) {
      this.winner = val
    }
  }
}
</script>
