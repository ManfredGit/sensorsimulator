/*
 * Copyright (C) 2008 - 2011 OpenIntents.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.openintents.tools.simulator.view.sensor.sensors;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.openintents.tools.simulator.model.sensor.sensors.SensorModel;
import org.openintents.tools.simulator.model.sensor.sensors.TemperatureModel;

/**
 * TemperatureView keeps the GUI of the Temperature sensor.
 * 
 * @author Peli
 * @author Josip Balic
 * 
 */
public class TemperatureView extends SensorView {
	private static final long serialVersionUID = 1000179101533155817L;

	public TemperatureView(TemperatureModel model) {
		super(model);
	}

	// Temperature
	private JTextField mTemperatureText;

	@Override
	public JPanel fillSensorSpecificSettingsPanel() {
		JPanel resultPanel = new JPanel(new GridBagLayout());
		resultPanel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Settings"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		GridBagConstraints c3 = new GridBagConstraints();
		GridBagConstraints c2 = new GridBagConstraints();
		TemperatureModel tempModel = (TemperatureModel) model;

		// //////////////////////////////
		// Temperature (in �C: Centigrade Celsius)
		JPanel temperatureFieldPane = new JPanel(new GridBagLayout());
		c3 = new GridBagConstraints();
		c3.fill = GridBagConstraints.HORIZONTAL;
		c3.anchor = GridBagConstraints.NORTHWEST;
		c3.gridwidth = 3;
		c3.gridx = 0;
		c3.gridy = 0;

		JLabel label = new JLabel("Temperature: ", JLabel.LEFT);
		c3.gridwidth = 1;
		c3.gridx = 0;
		c3.gridy++;
		temperatureFieldPane.add(label, c3);

		mTemperatureText = new JTextField(5);
		mTemperatureText.setText("" + tempModel.getTemperature());
		c3.gridx = 1;
		temperatureFieldPane.add(mTemperatureText, c3);

		label = new JLabel(" " + SensorModel.DEGREES + "C", JLabel.LEFT);
		c3.gridx = 2;
		temperatureFieldPane.add(label, c3);

		// Temperature panel ends

		// Add temperature panel to settings
		c2.gridx = 0;
		c2.gridwidth = 1;
		c2.gridy++;
		resultPanel.add(temperatureFieldPane, c2);
		return resultPanel;
	}

	public double getTemperature() {
		return getSafeDouble(mTemperatureText);
	}

	@Override
	protected JPanel getSensorSpecificHelp() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JPanel panel1 = new JPanel(new GridLayout(0, 1));
		panel1.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(2, 0, 0, 0, Color.GRAY),
				BorderFactory.createTitledBorder(
						BorderFactory.createEmptyBorder(3, 0, 15, 0),
						model.getName())));
		panel1.add(new JLabel("- measures the atmospheric temperature"));

		panel.add(panel1);
		return panel;
	}
}
