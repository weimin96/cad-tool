package com.wiblog.viewer.core.common;

import java.util.Arrays;
import java.util.List;

/**
 * describe:
 *
 * @author panwm
 * @since 2024/6/28 16:31
 */
public enum StrategyTypeEnum {

    DWG("dwg", Constant.MediaType.IMAGE_SVG_VALUE),
    DOC("doc", Constant.MediaType.PDF_VALUE),
    DOCX("docx", Constant.MediaType.PDF_VALUE),
    PDF("pdf", Constant.MediaType.PDF_VALUE),
    TXT("txt", Constant.MediaType.TXT_VALUE),
    JPG("jpg", Constant.MediaType.IMAGE_JPEG_VALUE),
    JPEG("jpeg", Constant.MediaType.IMAGE_JPEG_VALUE),
    PNG("png", Constant.MediaType.IMAGE_PNG_VALUE),
    GIF("gif", Constant.MediaType.IMAGE_GIF_VALUE)
    ;

    final String type;

    final String mediaType;

    public static final List<StrategyTypeEnum> PLAIN_TYPES = Arrays.asList(JPG, JPEG, PNG, GIF, PDF, TXT);

    public static final List<StrategyTypeEnum> WORD_TYPES = Arrays.asList(DOC, DOCX);

    public static final List<StrategyTypeEnum> CAD_TYPES = Arrays.asList(DWG);

    StrategyTypeEnum(String type, String mediaType) {
        this.type = type;
        this.mediaType = mediaType;
    }

    public static StrategyTypeEnum getStrategy(String type) {
        return Arrays.stream(StrategyTypeEnum.values())
                .filter(e -> e.type.equals(type))
                .findFirst()
                .orElse(null);
    }

    public static String getMediaType(String type) {
        return Arrays.stream(StrategyTypeEnum.values())
                .filter(e -> e.type.equals(type))
                .findFirst()
                .map(majorEnum -> majorEnum.mediaType)
                .orElse(null);
    }

    public String getType() {
        return type;
    }
}