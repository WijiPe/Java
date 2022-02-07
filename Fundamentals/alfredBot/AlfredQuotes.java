import java.util.Date;


class AlfredQuotes {
    public String basicGreeting(){
        return "Hello, lovely to see you. How are you?";
    }

    public String guestGreeting(String name){
        return "Hello, " + name + ". Lovely to see you.";
    }

    public String dateAnnouncement(){
        Date date = new Date();
        return ""+ date;
    }

    public String respondBeforeAlexis(String conversation){
        if(conversation.toLowerCase().indexOf("alexis") > -1){
            return "Right away, sir. She certainly isn't sophisticated enough for that.";
        }
        else if(conversation.toLowerCase().indexOf("alfred") > -1){
            return "At your service. As you wish, naturally.";
        }else{
            return "Right. And with that I shall retire.";
        }
    }

    public String alfredYell(String phrase){
        return phrase;
    }
}
