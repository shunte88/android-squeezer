package uk.org.ngo.squeezer.download;

import android.content.Context;

import uk.org.ngo.squeezer.R;
import uk.org.ngo.squeezer.framework.EnumWithText;
import uk.org.ngo.squeezer.model.Song;

public enum DownloadFilenameStructure implements EnumWithText{
    NUMBER_TITLE(R.string.download_filename_structure_number_title) {
        @Override
        public String get(Song song) {
            return formatTrackNumber(song.trackNum()) + " - " + song.name();
        }
    },
    ARTIST_TITLE(R.string.download_filename_structure_artist_title) {
        @Override
        public String get(Song song) {
            return song.artist() + " - " + song.name();
        }
    },
    ARTIST_NUMBER_TITLE(R.string.download_filename_structure_artist_number_title) {
        @Override
        public String get(Song song) {
            return song.artist() + " - " + formatTrackNumber(song.trackNum()) + " - " + song.name();
        }
    },
    ALBUMARTIST_NUMBER_TITLE(R.string.download_filename_structure_albumartist_number_title) {
        @Override
        public String get(Song song) {
            return song.album().artist() + " - " + formatTrackNumber(song.trackNum()) + " - " + song.name();
        }
    },
    TITLE(R.string.download_filename_structure_title) {
        @Override
        public String get(Song song) {
            return song.name();
        }
    },
    NUMBER_DOT_ARTIST_TITLE(R.string.download_filename_structure_number_dot_artist_title) {
        @Override
        public String get(Song song) {
            return formatTrackNumber(song.trackNum()) + ". " + song.artist() + " - " + song.name();
        }
    };

    private final int labelId;

    DownloadFilenameStructure(int labelId) {
        this.labelId = labelId;
    }

    @Override
    public String getText(Context context) {
        return context.getString(labelId);
    }

    public abstract String get(Song song);

    private static String formatTrackNumber(int trackNumber) {
       return String.format("%02d", trackNumber);
    }
}