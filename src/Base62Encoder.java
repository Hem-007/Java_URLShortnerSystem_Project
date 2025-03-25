public class Base62Encoder {

    String Base62 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    String encode(int code){
        StringBuilder encoded = new StringBuilder();
        if(code ==0){return String.valueOf(Base62.charAt(code));}
        while(code > 0){
            int rem = code % 62;
            char letter = Base62.charAt(rem);
            code /= 62;
            encoded.append(letter);
        }
        return encoded.reverse().toString();
    }

    int decode(String code){
        int decoded = 0;
        for(int i=0;i<code.length();i++){
            decoded = decoded * 62 + Base62.indexOf(code.charAt(i));
        }
        return decoded;
    }

}
