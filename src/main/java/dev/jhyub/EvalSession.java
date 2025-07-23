package dev.jhyub;

import dev.jhyub.objects.MalObject;

import java.util.Map;

public class EvalSession {
    MalObject obj;
    Map<String, MalObject> env;
    Map<String, MalObject> localEnv;

    public EvalSession(MalObject obj, Map<String, MalObject> env, Map<String, MalObject> localEnv) {
        this.obj = obj;
        this.env = env;
        this.localEnv = localEnv;
    }

    public MalObject getObject() {
        return obj;
    }

    public Map<String, MalObject> getEnv() {
        return env;
    }

    public Map<String, MalObject> getLocalEnv() {
        return localEnv;
    }
}
