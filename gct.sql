-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le :  mer. 09 sep. 2020 à 16:41
-- Version du serveur :  10.4.11-MariaDB
-- Version de PHP :  7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `gct`
--

-- --------------------------------------------------------

--
-- Structure de la table `cam`
--

CREATE TABLE `cam` (
  `id_cam` int(20) NOT NULL,
  `nom_cam` varchar(100) NOT NULL,
  `etat_cam` int(10) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `cam`
--

INSERT INTO `cam` (`id_cam`, `nom_cam`, `etat_cam`) VALUES
(1, 'AMN_CAM_DVR1', 1),
(2, 'AMN_CAM_DVR2', 0),
(3, 'APPRO_CAM_NVR', 1),
(4, 'extprincipal', 0),
(5, 'camint', 0),
(6, 'nvrdru', 1);

-- --------------------------------------------------------

--
-- Structure de la table `rapport`
--

CREATE TABLE `rapport` (
  `id_rapport` int(10) NOT NULL,
  `data` varchar(9999) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `rapport`
--

INSERT INTO `rapport` (`id_rapport`, `data`) VALUES
(7, '	host_name=AMN_SW_Pers\n	modified_attributes=0\n	check_command=check-host-alive\n	check_period=24x7\n	notification_period=24x7\n	check_interval=4.000000\n	retry_interval=4.000000\n	event_handler=\n	has_been_checked=1\n	should_be_scheduled=1\n	check_execution_time=0.017\n	check_latency=0.282\n	check_type=0\n	current_state=0\n	last_hard_state=0\n	last_event_id=2490880\n	current_event_id=2490953\n	current_problem_id=0\n	last_problem_id=1240257\n	plugin_output=PING OK - Packet loss = 0%, RTA = 3.82 ms\n	long_plugin_output=\n	performance_data=rta=3.821000ms;3000.000000;5000.000000;0.000000 pl=0%;80;100;0\n	last_check=1581068027\n	next_check=1581068277\n	check_options=0\n	current_attempt=1\n	max_attempts=4\n	state_type=0\n	last_state_change=1579942726\n	last_hard_state_change=1574846535\n	last_time_up=1581068037\n	last_time_down=1579942476\n	last_time_unreachable=0\n	last_notification=0\n	next_notification=0\n	no_more_notifications=0\n	current_notification_number=0\n	current_notification_id=2818424\n	notifications_enabled=1\n	problem_has_been_acknowledged=0\n	acknowledgement_type=0\n	active_checks_enabled=1\n	passive_checks_enabled=1\n	event_handler_enabled=1\n	flap_detection_enabled=1\n	failure_prediction_enabled=1\n	process_performance_data=1\n	obsess_over_host=0\n	last_update=1581068182\n	is_flapping=0\n	percent_state_change=0.00\n	scheduled_downtime_depth=0\n'),
(8, '	host_name=APPRO_SRV_DHCP/KAV\n	modified_attributes=0\n	check_command=check-host-alive\n	check_period=24x7\n	notification_period=24x7\n	check_interval=4.000000\n	retry_interval=1.000000\n	event_handler=\n	has_been_checked=1\n	should_be_scheduled=1\n	check_execution_time=0.019\n	check_latency=0.097\n	check_type=0\n	current_state=0\n	last_hard_state=0\n	last_event_id=2490890\n	current_event_id=2490927\n	current_problem_id=0\n	last_problem_id=1240267\n	plugin_output=PING OK - Packet loss = 0%, RTA = 1.47 ms\n	long_plugin_output=\n	performance_data=rta=1.466000ms;3000.000000;5000.000000;0.000000 pl=0%;80;100;0\n	last_check=1581068047\n	next_check=1581068297\n	check_options=0\n	current_attempt=1\n	max_attempts=4\n	state_type=0\n	last_state_change=1579942556\n	last_hard_state_change=1578656080\n	last_time_up=1581068057\n	last_time_down=1579942486\n	last_time_unreachable=0\n	last_notification=0\n	next_notification=0\n	no_more_notifications=0\n	current_notification_number=0\n	current_notification_id=3270190\n	notifications_enabled=1\n	problem_has_been_acknowledged=0\n	acknowledgement_type=0\n	active_checks_enabled=1\n	passive_checks_enabled=1\n	event_handler_enabled=1\n	flap_detection_enabled=1\n	failure_prediction_enabled=1\n	process_performance_data=1\n	obsess_over_host=0\n	last_update=1581068182\n	is_flapping=0\n	percent_state_change=0.00\n	scheduled_downtime_depth=0\n'),
(9, '	host_name=AMN_CAM_DVR1\n	modified_attributes=0\n	check_command=check-host-alive\n	check_period=24x7\n	notification_period=24x7\n	check_interval=4.000000\n	retry_interval=4.000000\n	event_handler=\n	has_been_checked=1\n	should_be_scheduled=1\n	check_execution_time=0.045\n	check_latency=0.083\n	check_type=0\n	current_state=0\n	last_hard_state=0\n	last_event_id=2490860\n	current_event_id=2490945\n	current_problem_id=0\n	last_problem_id=1240237\n	plugin_output=PING OK - Packet loss = 0%, RTA = 7.02 ms\n	long_plugin_output=\n	performance_data=rta=7.020000ms;3000.000000;5000.000000;0.000000 pl=0%;80;100;0\n	last_check=1581068007\n	next_check=1581068257\n	check_options=0\n	current_attempt=1\n	max_attempts=4\n	state_type=0\n	last_state_change=1579942686\n	last_hard_state_change=1579163230\n	last_time_up=1581068017\n	last_time_down=1579942436\n	last_time_unreachable=0\n	last_notification=0\n	next_notification=0\n	no_more_notifications=0\n	current_notification_number=0\n	current_notification_id=3329015\n	notifications_enabled=1\n	problem_has_been_acknowledged=0\n	acknowledgement_type=0\n	active_checks_enabled=1\n	passive_checks_enabled=1\n	event_handler_enabled=1\n	flap_detection_enabled=1\n	failure_prediction_enabled=1\n	process_performance_data=1\n	obsess_over_host=0\n	last_update=1581068182\n	is_flapping=0\n	percent_state_change=0.00\n	scheduled_downtime_depth=0\n'),
(10, '	host_name=AMN_CAM_DVR2\n	modified_attributes=0\n	check_command=check-host-alive!30000.0,20%!50000.0,60%\n	check_period=24x7\n	notification_period=24x7\n	check_interval=4.000000\n	retry_interval=4.000000\n	event_handler=\n	has_been_checked=1\n	should_be_scheduled=1\n	check_execution_time=0.070\n	check_latency=0.080\n	check_type=0\n	current_state=0\n	last_hard_state=0\n	last_event_id=2490858\n	current_event_id=2490944\n	current_problem_id=0\n	last_problem_id=1240233\n	plugin_output=PING OK - Packet loss = 0%, RTA = 1.75 ms\n	long_plugin_output=\n	performance_data=rta=1.754000ms;3000.000000;5000.000000;0.000000 pl=0%;80;100;0\n	last_check=1581068007\n	next_check=1581068257\n	check_options=0\n	current_attempt=1\n	max_attempts=4\n	state_type=0\n	last_state_change=1579942686\n	last_hard_state_change=1579337170\n	last_time_up=1581068017\n	last_time_down=1579942436\n	last_time_unreachable=0\n	last_notification=0\n	next_notification=0\n	no_more_notifications=0\n	current_notification_number=0\n	current_notification_id=3349307\n	notifications_enabled=1\n	problem_has_been_acknowledged=0\n	acknowledgement_type=0\n	active_checks_enabled=1\n	passive_checks_enabled=1\n	event_handler_enabled=1\n	flap_detection_enabled=1\n	failure_prediction_enabled=1\n	process_performance_data=1\n	obsess_over_host=0\n	last_update=1581068182\n	is_flapping=0\n	percent_state_change=0.00\n	scheduled_downtime_depth=0\n'),
(11, '	host_name=AMN_SW_AMNANCIEN\n	modified_attributes=0\n	check_command=check-host-alive\n	check_period=24x7\n	notification_period=24x7\n	check_interval=4.000000\n	retry_interval=4.000000\n	event_handler=\n	has_been_checked=1\n	should_be_scheduled=1\n	check_execution_time=0.049\n	check_latency=0.084\n	check_type=0\n	current_state=0\n	last_hard_state=0\n	last_event_id=2490859\n	current_event_id=2490946\n	current_problem_id=0\n	last_problem_id=1240234\n	plugin_output=PING OK - Packet loss = 0%, RTA = 3.67 ms\n	long_plugin_output=\n	performance_data=rta=3.669000ms;3000.000000;5000.000000;0.000000 pl=0%;80;100;0\n	last_check=1581068007\n	next_check=1581068257\n	check_options=0\n	current_attempt=1\n	max_attempts=4\n	state_type=0\n	last_state_change=1579942686\n	last_hard_state_change=1575707415\n	last_time_up=1581068017\n	last_time_down=1579942436\n	last_time_unreachable=0\n	last_notification=0\n	next_notification=0\n	no_more_notifications=0\n	current_notification_number=0\n	current_notification_id=2922517\n	notifications_enabled=1\n	problem_has_been_acknowledged=0\n	acknowledgement_type=0\n	active_checks_enabled=1\n	passive_checks_enabled=1\n	event_handler_enabled=1\n	flap_detection_enabled=1\n	failure_prediction_enabled=1\n	process_performance_data=1\n	obsess_over_host=0\n	last_update=1581068182\n	is_flapping=0\n	percent_state_change=0.00\n	scheduled_downtime_depth=0\n'),
(12, '	host_name=DRU_SRV_AD\n	modified_attributes=0\n	check_command=check-host-alive\n	check_period=24x7\n	notification_period=24x7\n	check_interval=4.000000\n	retry_interval=1.000000\n	event_handler=\n	has_been_checked=1\n	should_be_scheduled=1\n	check_execution_time=0.021\n	check_latency=0.260\n	check_type=0\n	current_state=0\n	last_hard_state=0\n	last_event_id=2491075\n	current_event_id=2491077\n	current_problem_id=0\n	last_problem_id=1240330\n	plugin_output=PING OK - Packet loss = 0%, RTA = 1.77 ms\n	long_plugin_output=\n	performance_data=rta=1.775000ms;3000.000000;5000.000000;0.000000 pl=0%;80;100;0\n	last_check=1581068077\n	next_check=1581068327\n	check_options=0\n	current_attempt=1\n	max_attempts=4\n	state_type=0\n	last_state_change=1581029862\n	last_hard_state_change=1574153768\n	last_time_up=1581068087\n	last_time_down=1581029792\n	last_time_unreachable=0\n	last_notification=0\n	next_notification=0\n	no_more_notifications=0\n	current_notification_number=0\n	current_notification_id=2751888\n	notifications_enabled=1\n	problem_has_been_acknowledged=0\n	acknowledgement_type=0\n	active_checks_enabled=1\n	passive_checks_enabled=1\n	event_handler_enabled=1\n	flap_detection_enabled=1\n	failure_prediction_enabled=1\n	process_performance_data=1\n	obsess_over_host=0\n	last_update=1581068182\n	is_flapping=0\n	percent_state_change=0.00\n	scheduled_downtime_depth=0\n'),
(13, '');

-- --------------------------------------------------------

--
-- Structure de la table `server`
--

CREATE TABLE `server` (
  `id_server` int(11) NOT NULL,
  `nom_server` varchar(110) NOT NULL,
  `etat_server` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `server`
--

INSERT INTO `server` (`id_server`, `nom_server`, `etat_server`) VALUES
(1, 'APPRO_SRV_DHCP_KAV', 1),
(2, 'DRU_SRV_AD', 0),
(3, 'DRU_SRV_Backup', 1),
(4, 'DRU_SRV_ESXI_GPM3', 1),
(5, 'DRU_SRV_GLPI_ANCIEN', 1),
(6, 'DRU_SRV_GPM3', 1),
(7, 'DRU_SRV_GPM3_Backp', 1),
(8, 'DRU_SRV_GedAlfresco', 1),
(9, 'DRU_SRV_KAV_HYP', 1),
(10, 'DRU_SRV_Helpdesk', 1),
(11, 'DRU_SRV_AD_Service', 1),
(12, 'DRU_SRV_Backup_Service', 1);

-- --------------------------------------------------------

--
-- Structure de la table `switcher`
--

CREATE TABLE `switcher` (
  `id_switcher` int(100) NOT NULL,
  `nom_switcher` varchar(110) NOT NULL,
  `etat_switcher` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `switcher`
--

INSERT INTO `switcher` (`id_switcher`, `nom_switcher`, `etat_switcher`) VALUES
(1, 'AMN_SW_AMNANCIEN', 0),
(2, 'AMN_SW_AMNNOUV', 1),
(3, 'AMN_SW_DPE', 1),
(4, 'AMN_SW_ELE_MC', 1),
(5, 'AMN_SW_ELE_MC1', 1),
(6, 'AMN_SW_MAG', 1),
(7, 'AMN_SW_NIT', 1),
(8, 'AMN_SW_Pers', 0),
(9, 'AMN_SW_RG36001', 1);

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `id` int(20) NOT NULL,
  `user` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `role` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`id`, `user`, `password`, `role`) VALUES
(10, 'admin', 'admin', 'security'),
(11, 'super', 'super', 'super'),
(12, 'network', 'network', 'network'),
(15, '', '', '');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `cam`
--
ALTER TABLE `cam`
  ADD PRIMARY KEY (`id_cam`);

--
-- Index pour la table `rapport`
--
ALTER TABLE `rapport`
  ADD PRIMARY KEY (`id_rapport`),
  ADD UNIQUE KEY `data` (`data`) USING HASH;

--
-- Index pour la table `server`
--
ALTER TABLE `server`
  ADD PRIMARY KEY (`id_server`);

--
-- Index pour la table `switcher`
--
ALTER TABLE `switcher`
  ADD PRIMARY KEY (`id_switcher`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `cam`
--
ALTER TABLE `cam`
  MODIFY `id_cam` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `rapport`
--
ALTER TABLE `rapport`
  MODIFY `id_rapport` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT pour la table `server`
--
ALTER TABLE `server`
  MODIFY `id_server` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT pour la table `switcher`
--
ALTER TABLE `switcher`
  MODIFY `id_switcher` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT pour la table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
