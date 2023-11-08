import { ref, computed } from "vue";
import { defineStore } from "pinia";
import axios from "axios";

export const useYoutubeStore = defineStore("youtube", () => {
	const videos = ref([]);
	const selectedVideo = ref(null);

	const youtubeSearch = (keyword) => {
		console.log(keyword);
		const URL = "https://www.googleapis.com/youtube/v3/search";
		const API_KEY = "AIzaSyAdXpx1wEc_rS_J0COH0Qtqic26zn06DR8";
		axios({
			url: URL,
			method: "GET",
			params: {
				key: API_KEY,
				part: "snippet",
				q: keyword,
				type: "video",
				maxResults: 10,
			},
		})
			.then((response) => {
				console.log(response);
				videos.value = response.data.items;
			})
			.catch(() => {});
	};

	const clickVideo = (video) => {
		console.log(video)
		selectedVideo.value = video;
	}

	return { youtubeSearch, videos, clickVideo, selectedVideo };
});
