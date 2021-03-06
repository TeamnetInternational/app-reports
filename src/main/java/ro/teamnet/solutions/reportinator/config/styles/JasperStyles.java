/*
 * Copyright (c) 2015 Teamnet S.A. All Rights Reserved.
 *
 * This source file may not be copied, modified or redistributed,
 * in whole or in part, in any form or for any reason, without the express
 * written consent of Teamnet S.A.
 */

package ro.teamnet.solutions.reportinator.config.styles;


import net.sf.jasperreports.engine.JRLineBox;
import net.sf.jasperreports.engine.JRStyle;
import net.sf.jasperreports.engine.design.JRDesignStyle;
import net.sf.jasperreports.engine.type.HorizontalTextAlignEnum;
import net.sf.jasperreports.engine.type.ModeEnum;
import net.sf.jasperreports.engine.type.VerticalTextAlignEnum;
import ro.teamnet.solutions.reportinator.config.Constants;
import ro.teamnet.solutions.reportinator.config.JasperConstants;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * An {@link java.lang.Enum} that holds all the {@link net.sf.jasperreports.engine.JRStyle} needed for the
 * {@link ro.teamnet.solutions.reportinator.bind.Binder} to bind them to the report template , in our case
 * a {@link net.sf.jasperreports.engine.design.JasperDesign}
 *
 * @author Andrei.Marica
 * @version 1.0 Date: 2/13/2015
 */
public enum JasperStyles {

    /**
     * It's a default style generally inherited by the other styles in order to conserve code
     */
    DEFAULT_STYLE {
        public JRStyle getStyle() {
            return getDefaultStyle();
        }
    },
    /**
     * General TABLE_STYLE to be used by the {@link net.sf.jasperreports.engine.design.JasperDesign}
     * for the cells , it draws the table using a JRLineBox
     */
    TABLE_STYLE {
        public JRStyle getStyle() {
            return getTableStyle();
        }
    },
    /**
     * General TABLE_STYLE to be used by the {@link net.sf.jasperreports.engine.design.JasperDesign}
     * for the cells , it draws the table using a JRLineBox
     */
    HEADER_TABLE_STYLE {
        public JRStyle getStyle() {
            return getTableHeaderStyle();
        }
    },
    /**
     * Columns content JRStyle to be used by the {@link net.sf.jasperreports.engine.design.JasperDesign}
     * for the JRDesignTextField , it customizes the values from the COLUMNS CONTENT
     */
    COLUMN_CONTENT_STYLE {
        public JRStyle getStyle() {
            return getColumnContentStyle();
        }
    },
    /**
     * Header column JRStyle to be used by the {@link net.sf.jasperreports.engine.design.JasperDesign}
     * for the JRDesignTextField , it customizes the values from the HEADER CONTENT
     */
    COLUMN_HEADER_STYLE {
        public JRStyle getStyle() {
            return getColumnHeaderStyle();
        }
    },
    /**
     * Footer column JRStyle to be used by the {@link net.sf.jasperreports.engine.design.JasperDesign}
     * for the JRDesignTextField , it customizes the value from the FOOTER CONTENT
     */
    COLUMN_FOOTER_STYLE {
        public JRStyle getStyle() {
            return getColumnFooterStyle();
        }

    };

    /**
     * Helper method that reuses the code by using the generated {@link net.sf.jasperreports.engine.JRStyle}
     * as a parent for future {@link net.sf.jasperreports.engine.design.JRDesignStyle} and by that
     * all these lines will be directly implemented in the specific JRDesignStyle
     *
     * @return default JRStyle
     */
    private static JRStyle getDefaultStyle() {
        JRDesignStyle defaultStyle = new JRDesignStyle();
        defaultStyle.setName(JasperConstants.JASPER_TABLE_DEFAULT_STYLE_NAME_IDENTIFIER_KEY);
        defaultStyle.setFontName(JasperConstants.JASPER_STYLE_FONT_NAME_IDENTIFIER_KEY);
        defaultStyle.setHorizontalTextAlign(HorizontalTextAlignEnum.CENTER);
        defaultStyle.setVerticalTextAlign(VerticalTextAlignEnum.MIDDLE);
        defaultStyle.setPdfFontName(JasperConstants.JASPER_PDF_FONT_NAME_IDENTIFIER_KEY);
        defaultStyle.setPdfEncoding(JasperConstants.JASPER_PDF_ENCODING_IDENTIFIER_KEY);
        defaultStyle.setFontSize(10.0f);
        defaultStyle.setPdfEmbedded(false);
        defaultStyle.setBlankWhenNull(true);

        return defaultStyle;
    }

    /**
     * Method that returns a table style , can be further customized here
     * Must be set on a {@link net.sf.jasperreports.components.table.DesignCell}
     *
     * @return A style for tables.
     */
    private static JRStyle getTableStyle() {
        JRDesignStyle tableStyle = new JRDesignStyle();
        tableStyle.setName(JasperConstants.JASPER_TABLE_STYLE_NAME_IDENTIFIER_KEY);
        setUpLineBox(tableStyle.getLineBox());

        return tableStyle;
    }

    /**
     * Method that returns a {@link net.sf.jasperreports.engine.design.JRDesignStyle} similar to TableStyle
     * but this one is used by the HeaderColumns and has a specific background color for {@link net.sf.jasperreports.components.table.DesignCell}
     *
     * @return A style for table headers.
     */
    private static JRStyle getTableHeaderStyle() {
        JRDesignStyle tableHeaderStyle = new JRDesignStyle();
        tableHeaderStyle.setName(JasperConstants.JASPER_TABLE_BOX_HEADER_STYLE_NAME_IDENTIFIER_KEY);
        tableHeaderStyle.setBackcolor(JasperConstants.JASPER_HEADER_BACKGROUND_COLOR);
        tableHeaderStyle.setMode(ModeEnum.OPAQUE);
        setUpLineBox(tableHeaderStyle.getLineBox());

        return tableHeaderStyle;
    }

    /**
     * Method that returns a column header style , can be further customized here
     * This style defines the elements in the header column of the generated Table
     * <p>
     * MUST BE SET ON A  {@link net.sf.jasperreports.engine.design.JRDesignTextField}
     *
     * @return A style for column headers.
     */
    private static JRStyle getColumnHeaderStyle() {
        JRDesignStyle columnHeaderStyle = new JRDesignStyle();
        columnHeaderStyle.setParentStyle(getDefaultStyle());
        columnHeaderStyle.setName(JasperConstants.JASPER_TABLE_HEADER_STYLE_NAME_IDENTIFIER_KEY);
        columnHeaderStyle.setForecolor(JasperConstants.JASPER_HEADER_FONT_COLOR);
        columnHeaderStyle.setBold(Boolean.TRUE);
        columnHeaderStyle.setFontSize(12.0f);

        return columnHeaderStyle;
    }

    /**
     * Method that returns a column content style , can be further customized here
     * This style defines the elements in the main body of the generated Table
     * <p>
     * MUST BE SET ON A {@link net.sf.jasperreports.engine.design.JRDesignTextField}
     *
     * @return A style for column content.
     */
    private static JRStyle getColumnContentStyle() {
        JRDesignStyle ColumnContentStyle = new JRDesignStyle();
        ColumnContentStyle.setParentStyle(getDefaultStyle());
        ColumnContentStyle.setName(JasperConstants.JASPER_TABLE_CONTENT_STYLE_NAME_IDENTIFIER_KEY);
        ColumnContentStyle.getLineBox().setLeftPadding(2);
        ColumnContentStyle.getLineBox().setRightPadding(2);

        return ColumnContentStyle;
    }

    /**
     * Method that returns a column footer style , can be further customized here
     * This style defines the elements in the  footer column of the generated Table
     * <p>
     * MUST BE SET ON A  {@link net.sf.jasperreports.engine.design.JRDesignTextField}
     *
     * @return A style for column footers.
     */
    private static JRStyle getColumnFooterStyle() {
        JRDesignStyle columnFooterStyle = new JRDesignStyle();
        columnFooterStyle.setParentStyle(getDefaultStyle());
        columnFooterStyle.setName(JasperConstants.JASPER_TABLE_FOOTER_STYLE_NAME_IDENTIFIER_KEY);
        columnFooterStyle.setBold(false);

        return columnFooterStyle;
    }

    /**
     * A helper method that sets the depending {@link net.sf.jasperreports.engine.design.JRDesignStyle} box and
     * also conserves the code for reusing it to other table styles
     *
     * @param lineBox that is sent from a {@link net.sf.jasperreports.engine.design.JRDesignStyle}
     *                using {@code getLineBox()}
     * @return a customized {@link net.sf.jasperreports.engine.JRLineBox}
     */
    private static JRLineBox setUpLineBox(JRLineBox lineBox) {
        lineBox.getLeftPen().setLineWidth(Constants.TABLE_BORDER_WIDTH);
        lineBox.getLeftPen().setLineColor(Color.BLACK);
        lineBox.getRightPen().setLineWidth(Constants.TABLE_BORDER_WIDTH);
        lineBox.getRightPen().setLineColor(Color.BLACK);
        lineBox.getBottomPen().setLineWidth(Constants.TABLE_BORDER_WIDTH);
        lineBox.getBottomPen().setLineColor(Color.BLACK);
        lineBox.getTopPen().setLineWidth(Constants.TABLE_BORDER_WIDTH);
        lineBox.getTopPen().setLineColor(Color.BLACK);

        return lineBox;
    }

    /**
     * A helper method which returns all the JasperReports report styles defined in this enum, as a {@link java.util.List}
     *
     * @return A list containing all contained report styles.
     */
    public static List<JRStyle> asList() {
        List<JRStyle> stylesList = new ArrayList<>();
        for (JasperStyles enumValue : values()) {
            stylesList.add(enumValue.getStyle());
        }

        return stylesList;
    }

    /**
     * Abstract method that has different implementations for each Style
     *
     * @return {@link net.sf.jasperreports.engine.JRStyle}
     */
    public abstract JRStyle getStyle();
}
