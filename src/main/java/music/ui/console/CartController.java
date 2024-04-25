package music.ui.console;

import music.application.CartService;
import music.ui.console.utils.InputUtils;

import java.util.Arrays;
import java.util.List;

public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    public void buy() {
        String inputAlbumIds = InputUtils.nextLine("구매할 앨범 아이디를 입력해 주세요");
        List<Long> albumIds = Arrays.stream(inputAlbumIds.split(","))
                .map(String::trim) /* ["1", "2", "3"]*/
                .map(this::parse) /* [1, 2, 3]*/
                .toList();
    // "1,2 , 3 ,4    , 5 ,   6  "
        // "1", "2 ", " 3", "4    ", " 5 ", "    6  ",
        // "1", "2", "3", "4", "5", "6",

//        Stream[1,2,3,4,5,6]
//         List[1,2,3,4,5,6]
        cartService.put(albumIds);
    }

    private Long parse(String id) {
        try {
            return Long.valueOf(id);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("앨범 아이디(숫자)를 입력해 주세요. - " + id);
        }
    }
}
