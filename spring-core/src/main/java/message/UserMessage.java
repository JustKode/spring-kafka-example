package message;

import lombok.*;
import org.msgpack.core.MessageBufferPacker;
import org.msgpack.core.MessagePack;
import org.msgpack.core.MessageUnpacker;

import java.io.IOException;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserMessage {
    private Integer senderUserId;
    private Integer receiverUserId;
    private String message;

    public byte[] packObject() throws IOException {
        MessageBufferPacker packer = MessagePack.newDefaultBufferPacker();
        packer
                .packInt(senderUserId)
                .packInt(receiverUserId)
                .packString(message);

        return packer.toByteArray();
    }

    public static UserMessage unpackObject(byte[] bytes) throws IOException {
        MessageUnpacker unpacker = MessagePack.newDefaultUnpacker(bytes);

        return UserMessage.builder()
                .senderUserId(unpacker.unpackInt())
                .receiverUserId(unpacker.unpackInt())
                .message(unpacker.unpackString())
                .build();
    }
}
