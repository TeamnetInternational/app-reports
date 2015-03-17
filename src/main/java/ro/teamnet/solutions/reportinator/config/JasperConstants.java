/*
 * Copyright (c) 2015 Teamnet S.A. All Rights Reserved.
 *
 * This source file may not be copied, modified or redistributed,
 * in whole or in part, in any form or for any reason, without the express
 * written consent of Teamnet S.A.
 */

package ro.teamnet.solutions.reportinator.config;

import ro.teamnet.solutions.reportinator.config.styles.JasperStyles;

/**
 * A class containing various constants related to JasperReports API configuration, to be used internally.
 *
 * @author Bogdan.Stefan
 * @version 1.0 Date: 2/11/2015
 */
public final class JasperConstants extends Constants {

    /**
     * A key used to create a parameter, as a placeholder, where to assign the header text at runtime.
     */
    public static final String JASPER_PAGE_HEADER_IDENTIFIER_KEY = "ReportinatorReportHeader";

    /**
     * A key used to create a parameter, as a placeholder, where to assign the footer text at runtime.
     */
    public static final String JASPER_PAGE_FOOTER_IDENTIFIER_KEY = "ReportinatorReportFooter";

    /**
     * A key used to create a parameter, as a placeholder, where to assign the report title text at runtime.
     */
    public static final String JASPER_TITLE_IDENTIFIER_KEY = "ReportinatorReportTitle";

    /**
     * A key used to create a parameter, as a placeholder, where to assign the report subtitle text at runtime.
     */
    public static final String JASPER_SUBTITLE_IDENTIFIER_KEY = "ReportinatorReportSubTitle";

    /**
     * A key used to create a parameter, as a placeholder, where to assign the report data set at runtime.
     */
    public static final String JASPER_DATASET_IDENTIFIER_KEY = "ReportinatorDataset";

    /**
     * A key used to create a parameter, as a placeholder, where to assign the report data source at runtime.
     */
    public static final String JASPER_DATASOURCE_IDENTIFIER_KEY = "ReportinatorDataSource";

    /**
     * A key used to identify a component key for the tables generated by this library.
     */
    public static final String JASPER_TABLE_IDENTIFIER_KEY = "ReportinatorTable";

    /**
     * A key used to identify if a loaded template is a built-in one, or a custom one.
     */
    public static final String JASPER_REPORT_DESIGN_NAME_KEY = "ReportinatorBuilt-inLoadedDesign";
    // TODO Physically create/add landscape and potrait default .JRXML templates below
    /**
     * Defines the path to the default, built-in, portrait JRXML template.
     */
    public static final String JASPER_JRXML_DEFAULT_PORTRAIT_TEMPLATE_PATH = "src/test/resources/jasper_test_blank_portrait_template.jrxml"; // FUTURE Modify with correct path
    /**
     * Defines the path to the default, built-in, landscape JRXML template.
     */
    public static final String JASPER_JRXML_DEFAULT_LANDSCAPE_TEMPLATE_PATH = "src/test/resources/jasper_test_blank_landscape_template.jrxml"; // FUTURE Modify with correct path

    /**
     * A key to be set as an internal identification means for the default table style.
     */
    public static final String JASPER_TABLE_DEFAULT_STYLE_NAME_IDENTIFIER_KEY = "ReportinatorDefaultTableStyle";

    /**
     * A key to be set as an internal identification means for the style defining the table borders.
     */
    public static final String JASPER_TABLE_BOX_HEADER_STYLE_NAME_IDENTIFIER_KEY = "ReportinatorHeaderTableBoxStyle";

    /**
     * A key to be set as an internal identification means for a table's content cell.
     */
    public static final String JASPER_TABLE_CONTENT_STYLE_NAME_IDENTIFIER_KEY = "ReportinatorTableContentStyle";

    /**
     * A key to be set as an internal identification means for a table's header.
     */
    public static final String JASPER_TABLE_HEADER_STYLE_NAME_IDENTIFIER_KEY = "ReportinatorTableHeaderStyle";

    /**
     * A key to be set as an internal identification means for a table's footer.
     */
    public static final String JASPER_TABLE_FOOTER_STYLE_NAME_IDENTIFIER_KEY = "ReportinatorTableFooterStyle";

    /**
     * A key to be set as an internal identification means for a table's style (in general).
     */
    public static final String JASPER_TABLE_STYLE_NAME_IDENTIFIER_KEY = "ReportinatorTableStyle";

    /**
     * A key to be set as an internal identification means for a report's font name.
     */
    public static final String JASPER_STYLE_FONT_NAME_IDENTIFIER_KEY = "SansSerif";

    /**
     * A key denoting the export font for PDFs.
     */
    public static final String JASPER_PDF_FONT_NAME_IDENTIFIER_KEY = "Helvetica";

    /**
     * A key denoting the export to PDF character enconding.
     */
    public static final String JASPER_PDF_ENCODING_IDENTIFIER_KEY = "Cp1252";

    /**
     * A key storing the minimum detail band's height.
     */
    public static final Integer JASPER_MINIMUM_BAND_DETAIL_HEIGHT = 300;

    /**
     * A key storing a table's content cell height (usually, this is {@code 2 * font size}).
     */
    public static final Integer JASPER_TABLE_MINIMUM_HEADER_CELL_HEIGHT = 2 * JasperStyles.COLUMN_HEADER_STYLE.getStyle().getFontsize().intValue();

    /**
     * A key storing the maximum number of columns, a report a can have, before switching from portrait to landscape
     * orientation, given the font size and style information.
     */
    public static final Integer JASPER_MAXIMUM_NUMBER_OF_COLUMNS_FOR_PORTRAIT;

    /**
     * A default value for the maximum number of columns, before a report switches orientation.
     *
     * @see ro.teamnet.solutions.reportinator.config.JasperConstants#JASPER_MAXIMUM_NUMBER_OF_COLUMNS_FOR_PORTRAIT
     * @see ro.teamnet.solutions.reportinator.config.Constants#CONFIGURATION_PROPERTIES
     */
    public static final String DEFAULT_JASPER_MAXIMUM_NUMBER_OF_COLUMNS_FOR_PORTRAIT = "8";

    static {
        // A holder reference
        String property;
        if(CONFIGURATION_PROPERTIES != null){
            property = CONFIGURATION_PROPERTIES.getProperty("JASPER_MAXIMUM_NUMBER_OF_COLUMNS_FOR_PORTRAIT", DEFAULT_JASPER_MAXIMUM_NUMBER_OF_COLUMNS_FOR_PORTRAIT);
            JASPER_MAXIMUM_NUMBER_OF_COLUMNS_FOR_PORTRAIT = Integer.valueOf(property);
        }
        else {
            JASPER_MAXIMUM_NUMBER_OF_COLUMNS_FOR_PORTRAIT = Integer.valueOf(DEFAULT_JASPER_MAXIMUM_NUMBER_OF_COLUMNS_FOR_PORTRAIT);
        }

    }

}
