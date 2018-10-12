package com.gamigo.tracker.model;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Entry {
	
	@Id
	private ObjectId id;
	
	@Indexed(unique = true)
	private Long userId;
	
	private Date downloadTime;
	
	private String gameKey;
	
	

	public Entry() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Entry(ObjectId id, Long userId, Date downloadTime, String gameKey) {
		this.id = id;
		this.userId = userId;
		this.downloadTime = downloadTime;
		this.gameKey = gameKey;
	}



	public String getId() {
		return id.toHexString();
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getDownloadTime() {
		return downloadTime;
	}

	public void setDownloadTime(Date downloadTime) {
		this.downloadTime = downloadTime;
	}

	public String getGameKey() {
		return gameKey;
	}

	public void setGameKey(String gameKey) {
		this.gameKey = gameKey;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Entry [id=").append(id).append(", userId=").append(userId).append(", downloadTime=")
				.append(downloadTime).append(", gameKey=").append(gameKey).append("]");
		return builder.toString();
	}
	
	
	

}
