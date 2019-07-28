package com.homepage.chain;

public abstract class Handler {

    private Handler sucessor;//后面的人

    public Handler getSucessor() {
        return sucessor;
    }

    public void setSucessor(Handler sucessor) {
        this.sucessor = sucessor;
    }

    protected abstract void handleProcess();

    public void execute() {
        handleProcess();
        //试下链式的调用
        if (this.sucessor != null) {
            this.sucessor.execute();
        }
    }
}
