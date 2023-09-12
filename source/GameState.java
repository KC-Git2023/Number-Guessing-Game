enum GameState {
    RUNNING, END;

    public String toString(){
        switch(this) {
            case RUNNING:   return "Running";
            case END:       return "End";
            default:        return "Unspecified";
        }
    }
}