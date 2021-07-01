package something.lambda.java8book.chapter3;

import java.util.List;
import java.util.Optional;

/**
 * 例 4-26 所示的 Artists 类表示了一组艺术家，重构该类，使得 getArtist 方法返回一 个 Optional<Artist>
 * 对象。如果索引在有效范围内，返回对应的元素，否则返回一个空 Optional 对象。此外，还需重构 getArtistName 方法，保持相同的行为。
 *
 * @author chenyu
 * @date 2021-07-01
 */
public class Artists {

  private List<Artist> artists;

  public Artists(List<Artist> artists) {
    this.artists = artists;
  }

  public Optional<Artist> getArtist(int index) {
    if (index < 0 || index >= artists.size()) {
      Optional.empty();
    }
    return Optional.ofNullable(artists.get(index));
  }

  private void indexException(int index) {
    throw new IllegalArgumentException(index + "doesn't correspond to an Artist");
  }

  public String getArtistName(int index) {
    try {
      Optional<Artist> artist = getArtist(index);
      return artist.map(e -> e.getName()).orElse("");
    } catch (IllegalArgumentException e) {
      return "unknown";
    }
  }
}

class Artist {
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
