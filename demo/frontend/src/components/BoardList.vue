<template>
  <div>
    <h3>Board List View</h3>
    <table boarder="1">
      <tr>
        <td align="center" width="80">No</td>
        <td align="center" width="320">Title</td>
        <td align="center" width="100">Writer</td>
        <td align="center" width="180">Registration</td>
      </tr>
      <tr v-if="!boards || (Array.isArray(boards) && boards.length ===0)">
        <td colspan="4">
          List is empty
        </td>
      </tr>

      <tr v-else v-for="board in boards" :key="board.boardNo">
        <td align="center">{{ board.boardNoi }}</td>
        <td align="left">
          <router-link :to="{ name: 'BoardReadPage',
                  params: { boardNo: board.boardNo.toString() }}">
            {{ board.title }}
          </router-link>
        </td>
          <td align="center">{{ board.writer }}</td>
        <td align="center">{{ board.regDate }}</td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: 'BoardList',
  props: {
    boards: {
      type: Array
    }
  }
}
</script>
