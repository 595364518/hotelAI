package com.cn.stbu.hotel.Tools.thread;

import com.cn.stbu.hotel.domain.FaceInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Datetime:    2020/3/25 0025   21:19
 * Author:  IDEA
 *INSERT INTO `hotel_ai`.`faceinfo`(`faceInfo_id`, `imgName`, `face_imgPath`, `face_feature`) VALUES ('bbbb', '梁海彬.jpg', 'F:', '0.0.-6.68.0.0.116.67.-108.-107.-123.61.-94.73.-10.60.117.108.-25.59.45.74.40.61.107.63.-110.-67.35.-74.-123.61.-120.4.23.-68.35.2.43.-67.-74.107.-67.57.89.-97.-95.-68.84.9.-82.-68.76.25.-87.-67.2.46.-38.-68.68.-78.-93.61.70.-38.-102.-68.82.90.27.61.113.-115.31.60.-14.-87.71.-67.83.-60.9.62.-85.66.52.-69.-14.-73.-37.61.120.-88.100.61.-42.29.-68.-67.-37.50.-99.-69.48.-23.-117.61.77.124.-32.-68.80.-23.-91.61.-101.-14.-19.60.-5.-73.91.-67.-92.-42.93.61.-105.33.52.61.-106.16.1.-68.-127.-90.58.-67.73.-69.-66.-68.-86.42.-23.60.-6.-106.-45.-67.-26.-118.-69.60.109.87.-115.-67.48.-81.-58.-71.21.-61.-87.-68.11.58.-49.-67.-5.-99.66.61.63.-73.9.61.109.80.74.-68.-102.95.51.61.-91.-13.-35.-67.-57.115.10.-66.44.-45.118.-67.-15.95.-127.-67.32.-64.-109.-67.-58.111.47.61.115.72.82.-68.-33.-15.-112.61.30.44.39.-66.2.-11.-70.59.123.-44.42.-68.98.110.32.60.109.-11.-45.60.30.-61.-76.-67.-108.3.98.-68.-7.74.15.-67.-27.58.-20.61.-117.-39.46.-67.-123.-66.113.-67.114.24.-92.59.-33.27.15.-67.118.-11.52.61.-44.21.83.61.-8.-5.-13.-67.-17.36.-127.-67.20.87.-97.-68.12.-101.-103.-67.-94.96.14.-68.87.17.-98.-67.86.-66.-47.59.123.52.-82.61.125.-56.53.61.103.57.107.61.-124.-64.126.58.-83.7.26.-67.-111.54.-115.-68.-71.89.-62.61.-23.71.-112.-67.126.-127.38.62.-108.34.71.-67.-39.12.-37.-67.-121.89.-86.61.-84.104.-66.61.-105.-26.-104.61.42.11.-124.-72.9.-29.80.-67.15.0.-57.-67.2.-1.-118.61.62.-45.-28.-68.120.-86.127.61.17.-39.-45.60.-78.60.-91.61.120.-87.-8.-68.76.115.27.61.-6.-76.-104.61.48.-31.-71.-67.-5.-10.-77.60.-74.50.-35.-68.-64.-4.45.-68.40.51.-93.60.-61.-62.79.-67.-30.-81.97.61.14.69.87.61.67.-67.-110.61.58.-53.69.61.-89.85.-100.-67.-117.-71.-22.60.97.-124.-76.61.54.-122.-88.61.89.-87.-74.60.-1.87.34.62.12.-119.37.-67.73.-22.-30.-68.-70.-56.69.61.-23.59.-57.60.-100.102.-119.-67.-80.-70.-32.60.-26.-119.80.61.115.-21.59.-68.-35.20.-128.61.-48.89.83.-67.97.-71.-20.-67.27.-38.87.-67.-5.73.87.-67.27.-9.98.60.-61.78.125.60.87.21.43.-67.40.-77.-117.59.-47.-46.102.-67.43.-80.30.61.80.-11.-86.-68.49.1.61.-69.11.78.50.-68.124.51.-58.60.42.-1.101.61.-81.55.-73.61.2.122.41.-69.21.-104.-124.-68.-2.104.15.61.-12.-88.107.61.-78.-25.28.62.100.85.-82.-68.-35.-17.20.62.62.-49.-40.61.2.-31.98.58.20.-66.65.-67.-51.-55.12.-68.-75.70.2.-68.82.-39.-111.-67.103.5.78.-67.-73.6.70.-67.100.-127.-57.-67.-21.52.-80.61.-106.-108.-117.-67.-68.34.-82.60.116.119.18.-67.-36.118.86.61.46.100.-123.-68.-82.84.34.61.-23.2.23.-68.51.-110.-128.-67.56.-105.-107.61.65.-13.27.60.97.15.72.61.76.-35.-60.-67.-83.17.-78.61.42.80.-113.61.91.103.84.-67.120.44.100.60.95.-26.-27.-67.23.-96.-44.60.-3.125.85.61.86.-96.-120.60.-108.-51.-119.-67.-122.-123.49.-67.-19.44.55.-67.52.33.48.61.86.124.3.61.-123.113.56.61.36.114.11.-67.47.-101.-54.61.-115.36.48.61.-27.-11.66.60.-18.-85.-54.58.-96.74.-85.-71.-61.101.22.61.52.2.75.61.-42.41.10.61.-11.125.1.61.-18.102.64.-67.98.109.-20.60.53.-36.109.61.17.-76.-81.61.-72.105.8.60.12.-64.117.60.-82.121.-38.60.90.-90.-82.61.0.123.55.-67.-118.65.2.-66.95.-20.-128.-69.-115.82.-22.59.-17.110.32.-69.-2.-17.-30.-69.-58.-82.19.59.-48.-101.-96.61.36.58.-26.-67.58.50.-3.61.-3.-6.124.-67.61.94.-111.-67.-71.54.22.59.58.79.49.61.-42.-106.40.61.21.8.-5.61.-126.9.-126.-67.119.120.-97.-67.-8.-9.6.61.-73.61.-6.60.86.7.-118.61.-111.-10.69.61.9.-31.-1.-68.-126.-52.63.-67.-111.106.-92.61.126.-19.-33.-67.-2.-95.-108.-68.56.-37.-81.-67.-64.-5.52.-67.56.27.92.60.-24.71.-17.-67.73.88.-123.61.-45.95.-60.-68.-96.-55.27.60.5.-109.38.-67.-121.110.-5.-68.77.23.115.-67.85.-86.94.-67.-43.64.2.-66.33.55.-114.61.-45.-35.19.61.13.-108.-72.-67.19.-29.-127.-69.-18.71.112.-68.9.-99.90.61.-75.-68.-85.60.106.4.-43.-68.-47.38.93.61.68.-8.126.61.68.32.-102.-67.123.19.61.62.-35.39.-90.-67.-8.-105.-77.61.72.-71.-65.61.');
 */
public class FaceInfoMapperDemo {
    private List<FaceInfo> list;

    public FaceInfoMapperDemo() {
        list = new ArrayList<FaceInfo>();
        list.add(new FaceInfo("bbbb", "梁海彬.jpg", "F:", "0.0.-6.68.0.0.116.67.-108.-107.-123.61.-94.73.-10.60.117.108.-25.59.45.74.40.61.107.63.-110.-67.35.-74.-123.61.-120.4.23.-68.35.2.43.-67.-74.107.-67.57.89.-97.-95.-68.84.9.-82.-68.76.25.-87.-67.2.46.-38.-68.68.-78.-93.61.70.-38.-102.-68.82.90.27.61.113.-115.31.60.-14.-87.71.-67.83.-60.9.62.-85.66.52.-69.-14.-73.-37.61.120.-88.100.61.-42.29.-68.-67.-37.50.-99.-69.48.-23.-117.61.77.124.-32.-68.80.-23.-91.61.-101.-14.-19.60.-5.-73.91.-67.-92.-42.93.61.-105.33.52.61.-106.16.1.-68.-127.-90.58.-67.73.-69.-66.-68.-86.42.-23.60.-6.-106.-45.-67.-26.-118.-69.60.109.87.-115.-67.48.-81.-58.-71.21.-61.-87.-68.11.58.-49.-67.-5.-99.66.61.63.-73.9.61.109.80.74.-68.-102.95.51.61.-91.-13.-35.-67.-57.115.10.-66.44.-45.118.-67.-15.95.-127.-67.32.-64.-109.-67.-58.111.47.61.115.72.82.-68.-33.-15.-112.61.30.44.39.-66.2.-11.-70.59.123.-44.42.-68.98.110.32.60.109.-11.-45.60.30.-61.-76.-67.-108.3.98.-68.-7.74.15.-67.-27.58.-20.61.-117.-39.46.-67.-123.-66.113.-67.114.24.-92.59.-33.27.15.-67.118.-11.52.61.-44.21.83.61.-8.-5.-13.-67.-17.36.-127.-67.20.87.-97.-68.12.-101.-103.-67.-94.96.14.-68.87.17.-98.-67.86.-66.-47.59.123.52.-82.61.125.-56.53.61.103.57.107.61.-124.-64.126.58.-83.7.26.-67.-111.54.-115.-68.-71.89.-62.61.-23.71.-112.-67.126.-127.38.62.-108.34.71.-67.-39.12.-37.-67.-121.89.-86.61.-84.104.-66.61.-105.-26.-104.61.42.11.-124.-72.9.-29.80.-67.15.0.-57.-67.2.-1.-118.61.62.-45.-28.-68.120.-86.127.61.17.-39.-45.60.-78.60.-91.61.120.-87.-8.-68.76.115.27.61.-6.-76.-104.61.48.-31.-71.-67.-5.-10.-77.60.-74.50.-35.-68.-64.-4.45.-68.40.51.-93.60.-61.-62.79.-67.-30.-81.97.61.14.69.87.61.67.-67.-110.61.58.-53.69.61.-89.85.-100.-67.-117.-71.-22.60.97.-124.-76.61.54.-122.-88.61.89.-87.-74.60.-1.87.34.62.12.-119.37.-67.73.-22.-30.-68.-70.-56.69.61.-23.59.-57.60.-100.102.-119.-67.-80.-70.-32.60.-26.-119.80.61.115.-21.59.-68.-35.20.-128.61.-48.89.83.-67.97.-71.-20.-67.27.-38.87.-67.-5.73.87.-67.27.-9.98.60.-61.78.125.60.87.21.43.-67.40.-77.-117.59.-47.-46.102.-67.43.-80.30.61.80.-11.-86.-68.49.1.61.-69.11.78.50.-68.124.51.-58.60.42.-1.101.61.-81.55.-73.61.2.122.41.-69.21.-104.-124.-68.-2.104.15.61.-12.-88.107.61.-78.-25.28.62.100.85.-82.-68.-35.-17.20.62.62.-49.-40.61.2.-31.98.58.20.-66.65.-67.-51.-55.12.-68.-75.70.2.-68.82.-39.-111.-67.103.5.78.-67.-73.6.70.-67.100.-127.-57.-67.-21.52.-80.61.-106.-108.-117.-67.-68.34.-82.60.116.119.18.-67.-36.118.86.61.46.100.-123.-68.-82.84.34.61.-23.2.23.-68.51.-110.-128.-67.56.-105.-107.61.65.-13.27.60.97.15.72.61.76.-35.-60.-67.-83.17.-78.61.42.80.-113.61.91.103.84.-67.120.44.100.60.95.-26.-27.-67.23.-96.-44.60.-3.125.85.61.86.-96.-120.60.-108.-51.-119.-67.-122.-123.49.-67.-19.44.55.-67.52.33.48.61.86.124.3.61.-123.113.56.61.36.114.11.-67.47.-101.-54.61.-115.36.48.61.-27.-11.66.60.-18.-85.-54.58.-96.74.-85.-71.-61.101.22.61.52.2.75.61.-42.41.10.61.-11.125.1.61.-18.102.64.-67.98.109.-20.60.53.-36.109.61.17.-76.-81.61.-72.105.8.60.12.-64.117.60.-82.121.-38.60.90.-90.-82.61.0.123.55.-67.-118.65.2.-66.95.-20.-128.-69.-115.82.-22.59.-17.110.32.-69.-2.-17.-30.-69.-58.-82.19.59.-48.-101.-96.61.36.58.-26.-67.58.50.-3.61.-3.-6.124.-67.61.94.-111.-67.-71.54.22.59.58.79.49.61.-42.-106.40.61.21.8.-5.61.-126.9.-126.-67.119.120.-97.-67.-8.-9.6.61.-73.61.-6.60.86.7.-118.61.-111.-10.69.61.9.-31.-1.-68.-126.-52.63.-67.-111.106.-92.61.126.-19.-33.-67.-2.-95.-108.-68.56.-37.-81.-67.-64.-5.52.-67.56.27.92.60.-24.71.-17.-67.73.88.-123.61.-45.95.-60.-68.-96.-55.27.60.5.-109.38.-67.-121.110.-5.-68.77.23.115.-67.85.-86.94.-67.-43.64.2.-66.33.55.-114.61.-45.-35.19.61.13.-108.-72.-67.19.-29.-127.-69.-18.71.112.-68.9.-99.90.61.-75.-68.-85.60.106.4.-43.-68.-47.38.93.61.68.-8.126.61.68.32.-102.-67.123.19.61.62.-35.39.-90.-67.-8.-105.-77.61.72.-71.-65.61."));
        list.add(new FaceInfo("aaaa", "何旭东老家.jpg", "F:\\AI酒店\\SDK的test图片\\系统人脸图片", "0.0.-6.68.0.0.116.67.-65.-50.-98.-70.-121.68.-33.60.114.1.-120.-67.-63.-11.115.61.96.-25.-63.-69.31.-70.-64.60.-14.-11.42.61.-35.55.6.-66.-10.37.-48.-67.-18.-43.3.-71.83.-33.17.-67.-76.-88.84.-69.-70.43.-117.-67.41.-94.99.-68.-4.13.-30.-68.85.-39.-43.-71.-41.67.93.-67.-17.2.-42.60.3.-91.-121.-69.-72.-78.-113.61.-113.-4.72.-67.1.53.-126.61.100.8.-119.-68.74.-50.4.-67.113.119.-83.-67.56.60.-15.-67.98.-15.10.62.-109.109.83.61.120.66.13.61.113.87.47.-67.-11.52.-95.-67.57.60.-44.61.76.-76.-109.61.-118.60.58.-67.-82.-13.56.-67.103.-21.58.-68.61.-45.2.-67.91.60.90.-67.-113.6.46.-67.-115.-43.9.61.-23.67.-29.-68.-103.100.2.-71.122.-61.58.61.-117.101.72.61.29.-120.24.62.-4.-25.98.61.-106.14.-84.-67.37.34.-13.-67.102.12.23.-66.-53.77.-113.61.71.114.-35.59.48.35.67.60.-64.107.-46.-68.-18.31.-70.-68.-118.-22.-35.-67.32.46.-100.-68.2.107.-24.60.-101.-7.99.61.-19.-68.-85.-67.58.70.-108.-67.-124.126.70.61.-94.12.68.60.-79.102.94.-67.-98.-18.-80.61.-25.55.-57.-67.-34.67.15.61.94.-47.44.60.48.21.-124.60.-25.27.-128.-68.46.107.-117.-67.-35.-55.-68.61.-53.7.-69.59.-90.-85.-57.-67.-51.114.-95.61.65.60.31.-67.-31.-24.26.-67.65.95.-35.59.-51.-99.121.61.-7.39.-23.60.-126.-85.42.-67.-59.14.-69.-67.95.73.127.61.89.76.-5.59.-68.-108.-18.-67.46.99.0.-67.-83.42.-125.-69.81.-40.-7.61.-3.114.-48.-67.-47.-120.-101.59.109.19.-1.60.-52.-7.54.-67.-106.17.-111.61.120.-38.-31.-67.-111.-103.-25.-68.-87.25.-109.-67.24.-1.-77.-67.-51.-31.-105.59.-84.110.59.-67.-45.41.53.-67.54.87.-27.61.-80.86.-128.61.-72.-3.-106.-68.113.87.-119.61.-8.-104.49.-67.113.32.-125.57.-40.66.79.61.74.-51.-13.-70.-100.-110.48.61.38.23.83.61.10.-24.24.61.-120.-49.-121.-67.-35.-62.-91.-67.20.23.-67.-68.42.3.-46.-70.54.40.-102.-67.-62.66.-66.-70.57.-23.5.-67.97.-86.78.-68.103.-16.16.61.-57.-20.-62.61.14.-107.-34.59.-56.-91.-13.-68.-12.-79.-125.61.-78.-45.-69.-67.31.-118.-68.-68.-98.-124.20.62.106.30.-48.-68.-6.2.81.-67.99.-81.-61.61.33.47.123.61.-70.-20.116.60.-117.-71.-50.60.-53.-127.41.60.112.26.67.61.76.-16.-48.58.70.67.-114.60.-128.-62.-43.-68.-91.-30.23.61.-10.-9.-74.60.-124.106.64.-67.-77.-100.-71.-69.4.54.-115.61.48.-102.-122.-67.-38.-37.40.-68.-111.104.-117.58.-71.77.-117.-67.26.36.-83.61.-4.106.-117.-67.46.-9.14.58.-97.-57.-72.-69.-32.-30.-39.-68.-117.9.-66.60.-28.-83.2.-66.26.-90.-82.61.27.77.82.61.-118.104.-32.60.-9.22.92.-67.102.-125.-121.61.104.-79.54.61.18.-31.116.-67.33.-111.21.-68.-33.113.-89.-69.-93.43.47.61.-109.13.-72.-67.41.-126.-48.-68.-43.93.-125.59.97.-2.90.-67.78.-116.-10.60.40.-30.-75.61.27.66.72.-68.42.-25.-121.-67.-30.11.47.-68.86.68.107.-68.122.34.-26.-67.-59.-37.-91.60.-100.44.-27.60.51.55.-77.60.31.41.-122.61.63.25.26.-67.-30.-47.-110.-68.55.-57.2.59.57.108.-105.-68.-100.-83.-3.-68.55.-107.8.61.46.-20.-3.-69.15.-98.-36.61.83.32.-91.-68.39.46.12.61.31.-46.-83.61.-124.48.31.57.-122.104.11.-68.62.57.103.-67.87.-33.35.-66.87.66.-30.-68.106.61.-114.61.-28.-120.9.61.12.127.75.-67.-52.-125.-26.61.-124.94.-32.-68.-91.-84.-64.61.-66.108.-117.-67.-66.-65.74.-67.62.-94.-93.61.70.92.-103.-67.102.-75.-82.61.100.-23.-75.61.-74.-19.114.-67.-20.43.-16.-68.51.6.-27.-68.-1.-55.99.61.-41.-117.-25.61.-84.12.-79.-68.106.-96.-114.60.94.-71.2.62.123.-89.22.-67.79.-32.-119.61.-63.96.100.60.-20.-123.-112.61.-34.115.87.61.-47.-24.-110.61.17.-29.-73.-68.-62.70.-6.-69.25.-42.7.61.60.72.53.-67.-99.-112.96.-68.127.72.69.61.-46.-36.81.-67.-4.91.105.-67.25.-39.10.-66.-57.-30.-78.61.-83.-101.6.61.-126.49.96.61.-107.-86.-67.-68.48.36.104.-67.-28.-42.-4.58.38.108.86.-67.-123.79.-34.-67.89.55.-85.-69.-102.42.-4.-68.-111.-17.-6.-67.-124.-21.93.62.-101.-83.-94.61.113.109.0.61.24.-3.41.-67.-126.-21.-68.-69.103.-49.-83.60.-68.-115.-29.61.-124.87.-75.60.33.49.99.61.-88.-80.31.61.54.-57.18.-67.119.35.-62.-67.-34.57.-114.-67.125.57.-17.-67.-117.-60.115.-67.13.-37.-52.61."));
    }

    public List<FaceInfo> getList(){
        return list;
    }
}
