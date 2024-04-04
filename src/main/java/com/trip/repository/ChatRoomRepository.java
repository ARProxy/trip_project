package com.trip.repository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRoomRepository {
//    private Map<String, ChatRoomDto> chatRoomDTOMap;
//
//    @PostConstruct
//    private void init(){
//        chatRoomDTOMap = new LinkedHashMap<>();
//    }
//
//    public default List<ChatRoomDto> findAllRooms(){
//        //채팅방 생성 순서 최근 순으로 반환
//        List<ChatRoomDto> result = new ArrayList<>(chatRoomDTOMap.values());
//        Collections.reverse(result);
//
//        return result;
//    }
//
//    public default ChatRoomDto findRoomById(String id){
//        return chatRoomDTOMap.get(id);
//    }
//
//    public default ChatRoomDto createChatRoomDTO(String name){
//        ChatRoomDto room = ChatRoomDto.create(name);
//        chatRoomDTOMap.put(room.getRoomId(), room);
//
//        return room;
//    }
//    @Query("select new com.example.forest.dto.chat.ChatRoomDto(cr.id, cr.name, u as creator, cr.modifiedTime) "
//            + " from ChatRoom cr, User u "
//            + " where cr.creatorId = u.id "
//            + " order by cr.modifiedTime desc")
//    List<ChatRoomDto> findAllRooms();
//
//    @Query("select new com.example.forest.dto.chat.ChatRoomDto(cr.id, cr.name, u as creator, cr.modifiedTime) "
//            + " from ChatRoom cr, User u "
//            + " where cr.creatorId = u.id "
//            + " and lower(cr.name) LIKE lower('%' || :keyword || '%') "
//            + " order by cr.modifiedTime desc")
//    List<ChatRoomDto> findAllRoomsByKeyword(@Param("keyword") String keyword);
}
