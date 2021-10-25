<template>
  <div class="content">
    <h1 class="title">
      <slot name="title"></slot>
    </h1>
    <ul>
      <li>
        <div class="song-item">
          <span class="item-index"></span>
          <span class="item-title">歌单名</span>
          <span class="item-intro">风格</span>
        </div>
      </li>
      <li v-for="(item,index) in songListData" :key="index">
        <div class="song-item" @click="toAlbum(item)">
          <span class="item-index" v-text="index + 1"></span>
          <span class="item-title" v-text="item.title"></span>
          <span class="item-intro" v-text="item.style"></span>
        </div>
      </li>
    </ul>
  </div>
</template>

<script>
import {likeSongListOfName} from '../../api'

export default {
  name: 'search-song-lists',
  data () {
    return {
      songListData: []
    }
  },
  watch: {
    '$route' (to, from) {
      this.getSongListData()
    }
  },
  mounted () {
    this.getSongListData()
  },
  methods: {
    getSongListData () {
      if (!this.$route.query.keywords) {
        this.songListData = []
        this.message('error', '您输入的内容为空')
      } else {
        likeSongListOfName(this.$route.query.keywords).then(res => {
          console.log(res)
          if (!res.length) { // 无数据
            this.message('error', '系统中暂无符合条件的歌单')
          } else {
            this.songListData = res
          }
        }).catch(err => {
          console.log(err)
        })
      }
    },
    toAlbum (item) {
      this.$store.commit('setTempList', item)
      this.$router.push({path: `song-list-album/${item.id}`})
    }
  }
}
</script>

<style lang="scss" scoped>
@import "../../assets/css/album-content.scss";
</style>
