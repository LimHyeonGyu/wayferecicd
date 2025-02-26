package edu.example.wayfarer.service;

import edu.example.wayfarer.dto.memberRoom.MemberRoomRequestDTO;
import edu.example.wayfarer.dto.memberRoom.MemberRoomResponseDTO;
import edu.example.wayfarer.dto.room.RoomListDTO;

import java.util.List;

public interface MemberRoomService {

    public MemberRoomResponseDTO create(MemberRoomRequestDTO memberRoomRequestDTO);

    public void delete(String email, String roomId);

    public List<MemberRoomResponseDTO> listByRoomId(String roomId);

    public List<RoomListDTO> listByEmail(String email);

}
