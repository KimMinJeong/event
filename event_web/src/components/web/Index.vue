<template>
  <div class="movies">
    <h1>영화 목록(MOBILE) </h1>
    <div v-for="movie in movies" class="movie" v-bind:key="movie.id">
      <img v-bind:src="movie.poster" class="poster" style="max-width:185px;">
      <div>
        <router-link :to="{ name: 'Show', params: { id: movie.id }}">더보기</router-link>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  created () {
    this.$http.get('/api/movies')
    .then((response) => {
      this.movies = response.data
    })
  },
  data () {
    return {
      movies: []
    }
  }
}
</script>