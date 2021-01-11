package com.hawolt.objects;

import com.hawolt.SellyJson;
import org.json.JSONObject;

public class Blacklist extends SellyJson {
    private String id, blocked_data, note, createdAt, updatedAt;
    private int blacklistType;

    public Blacklist(JSONObject o) {
        super(o);
        this.id = o.getString("id");
        this.blacklistType = o.getInt("blacklist_type");
        this.blocked_data = o.getString("blocked_data");
        this.note = o.getString("note");
        this.createdAt = o.getString("created_at");
        this.updatedAt = o.getString("updated_at");
    }

    public String getId() {
        return id;
    }

    public String getBlocked_data() {
        return blocked_data;
    }

    public String getNote() {
        return note;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public int getBlacklistType() {
        return blacklistType;
    }
}
