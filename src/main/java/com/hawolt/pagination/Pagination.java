package com.hawolt.pagination;

import com.hawolt.SellyException;
import com.hawolt.SellyJson;
import com.hawolt.SellyRequest;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;

public class Pagination<T extends SellyJson> implements ExceptionalIterable<List<T>> {

    protected Direction direction;

    private String location;
    private int index, total;
    private SellyRequest initial;
    private Class<T> reference;

    public Pagination(Class<T> reference, String location, SellyRequest initial, Direction direction) {
        this.total = initial.getTotalPages();
        this.reference = reference;
        this.location = location;
        this.direction = direction;
        this.initial = initial;
        this.index = 1 + (direction == Direction.ASCENDING ? 0 : initial.getTotalPages());
    }

    public int getIndex() {
        return index;
    }

    public int getTotal() {
        return total;
    }

    @Override
    public boolean hasNext() {
        return direction == Direction.ASCENDING ? index < total : index > 0;
    }

    @Override
    public List<T> next() throws IOException, SellyException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        if (index == 1) {
            index += 1;
            return convert(initial);
        }
        int tmp = direction == Direction.ASCENDING ? 1 : -1;
        SellyRequest request = SellyRequest.get(String.format("%s?page=%s", location, index + (tmp)));
        index += tmp;
        return convert(request);
    }

    public List<T> convert(SellyRequest request) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        JSONArray array = new JSONArray(request.getBody());
        List<T> list = new LinkedList<>();
        if (direction == Direction.ASCENDING) {
            for (int i = 0; i < array.length(); i++) {
                list.add(create(array.getJSONObject(i)));
            }
        } else {
            for (int i = array.length() - 1; i >= 0; i--) {
                list.add(create(array.getJSONObject(i)));
            }
        }
        return list;
    }

    public T create(JSONObject o) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        SellyJson json = SellyJson.class.getDeclaredConstructor(JSONObject.class).newInstance(o);
        return (T) json.asTypeOf(reference);
    }

    public enum Direction {
        ASCENDING, DESCENDING
    }
}
