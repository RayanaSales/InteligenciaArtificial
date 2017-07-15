package controlers;

import java.awt.BasicStroke;
import java.awt.Color;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYDotRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;

import models.Amostra;
import models.Centro;

public class PlotarGrafico extends ApplicationFrame
{
	List<Centro> centros;

	public PlotarGrafico(String applicationTitle, String chartTitle, List<Centro> lista)
	{
		super(applicationTitle);
		this.centros = lista;
		JFreeChart xylineChart = ChartFactory.createXYLineChart(chartTitle, "X", "Y", createDataset(),
				PlotOrientation.VERTICAL, true, true, false);

		ChartPanel chartPanel = new ChartPanel(xylineChart);
		chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
		final XYPlot plot = xylineChart.getXYPlot();
		// XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
		XYDotRenderer renderer = new XYDotRenderer();
		renderer.setDotHeight(8);
		renderer.setDotWidth(8);

		renderer.setSeriesPaint(0, Color.BLACK);
		renderer.setSeriesPaint(1, Color.RED);
		renderer.setSeriesPaint(2, Color.YELLOW);
		renderer.setSeriesPaint(3, Color.BLUE);
		renderer.setSeriesPaint(4, Color.GREEN);
		renderer.setSeriesPaint(5, Color.MAGENTA);
		renderer.setSeriesPaint(6, Color.WHITE);
		renderer.setSeriesPaint(7, Color.DARK_GRAY);
		renderer.setSeriesPaint(8, Color.CYAN);
		renderer.setSeriesPaint(9, Color.PINK);
		 renderer.setSeriesStroke( 0 , new BasicStroke( 4.0f ) );
		 renderer.setSeriesStroke( 1 , new BasicStroke( 3.0f ) );
		 renderer.setSeriesStroke( 2 , new BasicStroke( 2.0f ) );
		plot.setRenderer(renderer);
		setContentPane(chartPanel);
	}

	private XYDataset createDataset()
	{
		final XYSeriesCollection dataset = new XYSeriesCollection();
		
		try
		{
			// Adiciono os centros de cada grupo
			for (Centro g : this.centros)
			{
				final XYSeries grupo = new XYSeries("Centro: " + g.grupo.tipo);
				grupo.add(g.valor1, g.valor2);
				dataset.addSeries(grupo);
			}

			// Adiciono os individuos
			for (Centro g : this.centros)
			{
				final XYSeries grupo = new XYSeries(g.grupo.tipo);

				for (Amostra amostra : g.grupo.amostras)
				{
					grupo.add(amostra.Atributo1, amostra.Atributo2);

					
				}
				dataset.addSeries(grupo);
			}
		}catch(java.lang.IllegalArgumentException e)
		{
			System.out.println("deu merda");
			e.getStackTrace();
		}
		
		return dataset;
	}
}
