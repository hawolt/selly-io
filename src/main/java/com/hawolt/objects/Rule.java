package com.hawolt.objects;

import com.hawolt.SellyJson;
import org.json.JSONObject;

public class Rule extends SellyJson {
    private String id, title, name, rule, createdAt, updatedAt;
    private boolean enabled, actionType;

    public Rule(JSONObject o) {
        super(o);
        this.id = o.getString("id");
        this.title = o.getString("title");
        this.actionType = o.getString("action_type").equals("allow");
        this.name = o.getString("name");
        this.rule = o.getString("rule");
        this.enabled = o.getBoolean("enabled");
        this.createdAt = o.getString("created_at");
        this.updatedAt = o.getString("updated_at");
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getName() {
        return name;
    }

    public String getRule() {
        return rule;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public boolean isActionType() {
        return actionType;
    }
}
