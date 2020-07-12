package com.kalyan.album.practice.album.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "title", "description", "datetime", "cover", "cover_edited", "cover_width", "cover_height",
		"account_url", "account_id", "privacy", "layout", "views", "link", "favorite", "nsfw", "section",
		"images_count", "in_gallery", "is_ad", "include_album_ads", "is_album", "deletehash", "images", "ad_config" })
public class Data {

	@JsonProperty("id")
	private String id;
	@JsonProperty("title")
	private String title;
	@JsonProperty("description")
	private String description;
	@JsonProperty("datetime")
	private Integer datetime;
	@JsonProperty("cover")
	private String cover;
	@JsonProperty("cover_edited")
	private Object coverEdited;
	@JsonProperty("cover_width")
	private Integer coverWidth;
	@JsonProperty("cover_height")
	private Integer coverHeight;
	@JsonProperty("account_url")
	private String accountUrl;
	@JsonProperty("account_id")
	private Integer accountId;
	@JsonProperty("privacy")
	private String privacy;
	@JsonProperty("layout")
	private String layout;
	@JsonProperty("views")
	private Integer views;
	@JsonProperty("link")
	private String link;
	@JsonProperty("favorite")
	private Boolean favorite;
	@JsonProperty("nsfw")
	private Boolean nsfw;
	@JsonProperty("section")
	private Object section;
	@JsonProperty("images_count")
	private Integer imagesCount;
	@JsonProperty("in_gallery")
	private Boolean inGallery;
	@JsonProperty("is_ad")
	private Boolean isAd;
	@JsonProperty("include_album_ads")
	private Boolean includeAlbumAds;
	@JsonProperty("is_album")
	private Boolean isAlbum;
	@JsonProperty("deletehash")
	private String deletehash;
	@JsonProperty("images")
	private List<Image> images = null;
	@JsonProperty("ad_config")
	private AdConfig adConfig;

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("title")
	public String getTitle() {
		return title;
	}

	@JsonProperty("title")
	public void setTitle(String title) {
		this.title = title;
	}

	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	@JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
	}

	@JsonProperty("datetime")
	public Integer getDatetime() {
		return datetime;
	}

	@JsonProperty("datetime")
	public void setDatetime(Integer datetime) {
		this.datetime = datetime;
	}

	@JsonProperty("cover")
	public String getCover() {
		return cover;
	}

	@JsonProperty("cover")
	public void setCover(String cover) {
		this.cover = cover;
	}

	@JsonProperty("cover_edited")
	public Object getCoverEdited() {
		return coverEdited;
	}

	@JsonProperty("cover_edited")
	public void setCoverEdited(Object coverEdited) {
		this.coverEdited = coverEdited;
	}

	@JsonProperty("cover_width")
	public Integer getCoverWidth() {
		return coverWidth;
	}

	@JsonProperty("cover_width")
	public void setCoverWidth(Integer coverWidth) {
		this.coverWidth = coverWidth;
	}

	@JsonProperty("cover_height")
	public Integer getCoverHeight() {
		return coverHeight;
	}

	@JsonProperty("cover_height")
	public void setCoverHeight(Integer coverHeight) {
		this.coverHeight = coverHeight;
	}

	@JsonProperty("account_url")
	public String getAccountUrl() {
		return accountUrl;
	}

	@JsonProperty("account_url")
	public void setAccountUrl(String accountUrl) {
		this.accountUrl = accountUrl;
	}

	@JsonProperty("account_id")
	public Integer getAccountId() {
		return accountId;
	}

	@JsonProperty("account_id")
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	@JsonProperty("privacy")
	public String getPrivacy() {
		return privacy;
	}

	@JsonProperty("privacy")
	public void setPrivacy(String privacy) {
		this.privacy = privacy;
	}

	@JsonProperty("layout")
	public String getLayout() {
		return layout;
	}

	@JsonProperty("layout")
	public void setLayout(String layout) {
		this.layout = layout;
	}

	@JsonProperty("views")
	public Integer getViews() {
		return views;
	}

	@JsonProperty("views")
	public void setViews(Integer views) {
		this.views = views;
	}

	@JsonProperty("link")
	public String getLink() {
		return link;
	}

	@JsonProperty("link")
	public void setLink(String link) {
		this.link = link;
	}

	@JsonProperty("favorite")
	public Boolean getFavorite() {
		return favorite;
	}

	@JsonProperty("favorite")
	public void setFavorite(Boolean favorite) {
		this.favorite = favorite;
	}

	@JsonProperty("nsfw")
	public Boolean getNsfw() {
		return nsfw;
	}

	@JsonProperty("nsfw")
	public void setNsfw(Boolean nsfw) {
		this.nsfw = nsfw;
	}

	@JsonProperty("section")
	public Object getSection() {
		return section;
	}

	@JsonProperty("section")
	public void setSection(Object section) {
		this.section = section;
	}

	@JsonProperty("images_count")
	public Integer getImagesCount() {
		return imagesCount;
	}

	@JsonProperty("images_count")
	public void setImagesCount(Integer imagesCount) {
		this.imagesCount = imagesCount;
	}

	@JsonProperty("in_gallery")
	public Boolean getInGallery() {
		return inGallery;
	}

	@JsonProperty("in_gallery")
	public void setInGallery(Boolean inGallery) {
		this.inGallery = inGallery;
	}

	@JsonProperty("is_ad")
	public Boolean getIsAd() {
		return isAd;
	}

	@JsonProperty("is_ad")
	public void setIsAd(Boolean isAd) {
		this.isAd = isAd;
	}

	@JsonProperty("include_album_ads")
	public Boolean getIncludeAlbumAds() {
		return includeAlbumAds;
	}

	@JsonProperty("include_album_ads")
	public void setIncludeAlbumAds(Boolean includeAlbumAds) {
		this.includeAlbumAds = includeAlbumAds;
	}

	@JsonProperty("is_album")
	public Boolean getIsAlbum() {
		return isAlbum;
	}

	@JsonProperty("is_album")
	public void setIsAlbum(Boolean isAlbum) {
		this.isAlbum = isAlbum;
	}

	@JsonProperty("deletehash")
	public String getDeletehash() {
		return deletehash;
	}

	@JsonProperty("deletehash")
	public void setDeletehash(String deletehash) {
		this.deletehash = deletehash;
	}

	@JsonProperty("images")
	public List<Image> getImages() {
		return images;
	}

	@JsonProperty("images")
	public void setImages(List<Image> images) {
		this.images = images;
	}

	@JsonProperty("ad_config")
	public AdConfig getAdConfig() {
		return adConfig;
	}

	@JsonProperty("ad_config")
	public void setAdConfig(AdConfig adConfig) {
		this.adConfig = adConfig;
	}

}
