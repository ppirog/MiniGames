package app.lotto;

import lombok.AllArgsConstructor;

import java.util.Set;

@AllArgsConstructor
class LottoGameVerficator {

    public static final String RESULT = "Result: ";
    public static final String USER_NUMBERS = "User numbers: ";
    public static final String LOTTO_NUMBERS = "Lotto numbers: ";
    private Set<Integer> userSet;
    private Set<Integer> resultSet;


    public String verifyUserResult() {

        int resultOfGame = 0;

        for (var num : userSet) {
            if(resultSet.contains(num)){
                resultOfGame++;
            }
        }
        StringBuilder textResult = new StringBuilder();
        textResult.append(printResult(resultOfGame)).append("\n");
        textResult.append(printUserNumbers()).append("\n");
        textResult.append(printLottoNumbers()).append("\n");
        return textResult.toString();
    }
    private String printResult(int num){
        return RESULT + num;
    }
    private String printUserNumbers(){
        StringBuilder builder = new StringBuilder(USER_NUMBERS);
        for(var num : userSet){
            builder.append(num).append(" ");
        }
        return builder.toString();
    }
    private String printLottoNumbers(){
        StringBuilder builder = new StringBuilder(LOTTO_NUMBERS);
        for(var num : resultSet){
            builder.append(num).append(" ");
        }
        return builder.toString();
    }
}
