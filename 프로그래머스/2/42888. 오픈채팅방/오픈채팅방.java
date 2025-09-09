import java.util.ArrayList;
import java.util.HashMap;
// uid 고정된 값, 닉네임은 변경 <= key, value 로 관리하는 HashMap 자료구조
// 채팅 메시지에는 변경 부분은 없다. 들어오고, 나가는 것만 관리
// 교재 풀이는 메시지 구조를 HashMap 으로 관리
public class Solution{
    public static void main(String[] args) {
        String[] r = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        new Solution().solution(r);
    }
    
    public String[] solution(String[] record) {
        
        // Enter, Leave 에 대한 메시지
        HashMap<String, String> msg = new HashMap<>();
        msg.put("Enter", "님이 들어왔습니다.");
        msg.put("Leave", "님이 나갔습니다.");
        
        // uid, 닉네임 관리 <= 닉네임이 변경되면 덮어쓴다. (최신화, 현행화)
        // record 를 하나씩 확인하면서 uid, 닉네임이 변경되는 항목 (Enter, Change) 을 처리
        // 최종적인 답 ( 채팅 메시지 ) 는 Enter, Leave 로 구성되는 데, 현재 최종 닉네임을 사용해서 만들어야 한다.
        // 이걸 위해서 미리 uid 에 최종적인 닉네임을 관리
        HashMap<String, String> uid = new HashMap<>();
        
        for (String s : record) {
            String[] cmd = s.split(" "); // "Enter uid1234 Muzi" => {"Enter", "uid1234", "Muzi"} 
            if( cmd.length == 3 ) { // Enter, Change
                uid.put(cmd[1], cmd[2]);
            }
        }
        
        // 정답을 위한 자료구조 List
        ArrayList<String> answer = new ArrayList<>();
        for (String s : record) {
            String[] cmd = s.split(" "); // "Enter uid1234 Muzi" => {"Enter", "uid1234", "Muzi"} 
            if( msg.containsKey( cmd[0]) ) {
                answer.add( uid.get( cmd[1] ) + msg.get( cmd[0] ));
            }
        }
        
        return answer.toArray(new String[0]);
    }
}
