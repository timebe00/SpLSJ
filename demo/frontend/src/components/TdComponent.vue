<template>
  <td @click="onClickTd">{{ cellData }}</td>
</template>

<script>
export default {
  data () {
    return {
      game: {
        propTurn: this.turn,
        propWin: this.winner
      }
    }
  },

  //  아래에서 위로
  props: {
    // GlobalComponent ===> global-component
    cellData: String,
    rowIndex: Number,
    cellIndex: Number,
    tableData: Array,
    turn: String,
    winner: String
  },
  methods: {
    onClickTd () {
      if (this.cellData) return
      this.$set(this.tableData[this.rowIndex], this.cellIndex, this.turn)
      let win = false
      if (
        this.tableData[this.rowIndex][0] === this.turn &&
        this.tableData[this.rowIndex][1] === this.turn &&
        this.tableData[this.rowIndex][2] === this.turn
      ) {
        win = true
      }
      if (
        this.tableData[0][this.cellIndex] === this.turn &&
          this.tableData[1][this.cellIndex] === this.turn &&
          this.tableData[2][this.cellIndex] === this.turn
      ) {
        win = true
      }
      if (
        this.tableData[0][0] === this.turn &&
          this.tableData[1][1] === this.turn &&
          this.tableData[2][2] === this.turn
      ) {
        win = true
      }
      if (
        this.tableData[0][2] === this.turn &&
          this.tableData[1][1] === this.turn &&
      this.tableData[2][0] === this.turn
      ) {
        win = true
      }
      if (win) {
      //  하위에 데이터 전달
        this.game.propWin = this.turn
        this.$emit('updateWinner', this.game.propWin)
        this.$emit('updateTurn', 'O')
        this.$emit('updateTableData')
      } else {
        let all = true
        //  모든 셀들이 체크가 되었는가?
        this.tableData.forEach(row => {
          row.forEach(cell => {
            if (!cell) {
              all = false
            }
          })
        })
        if (all) {
          this.propWin = ''
          this.$emit('updateTurn', 'O')
          this.$emit('updateTableData')
        } else {
          this.game.propTurn = this.turn === 'O' ? 'X' : 'O'
          this.$emit('updateTurn', this.game.propTurn)
        }
      }
    }
  },
  mounted: function () {
    console.log('tableData: ' + this.tableData +
                ', turn: ' + this.turn +
                ', winner: ' + this.winner)
  }
}
</script>

<style></style>
