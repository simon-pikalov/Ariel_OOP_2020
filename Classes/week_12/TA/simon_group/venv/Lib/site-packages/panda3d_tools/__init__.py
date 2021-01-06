import os, sys
import panda3d

dir = os.path.dirname(panda3d.__file__)
del panda3d

if sys.platform in ('win32', 'cygwin'):
    path_var = 'PATH'
    if hasattr(os, 'add_dll_directory'):
        os.add_dll_directory(dir)
elif sys.platform == 'darwin':
    path_var = 'DYLD_LIBRARY_PATH'
else:
    path_var = 'LD_LIBRARY_PATH'

if not os.environ.get(path_var):
    os.environ[path_var] = dir
else:
    os.environ[path_var] = dir + os.pathsep + os.environ[path_var]

del os, sys, path_var, dir


def _exec_tool(tool):
    import os, sys
    from subprocess import Popen
    tools_dir = os.path.dirname(__file__)
    handle = Popen(sys.argv, executable=os.path.join(tools_dir, tool))
    try:
        try:
            return handle.wait()
        except KeyboardInterrupt:
            # Give the program a chance to handle the signal gracefully.
            return handle.wait()
    except:
        handle.kill()
        handle.wait()
        raise

# Register all the executables in this directory as global functions.
apply_patch = lambda: _exec_tool('apply_patch.exe')
bam_info = lambda: _exec_tool('bam-info.exe')
bam2egg = lambda: _exec_tool('bam2egg.exe')
build_patch = lambda: _exec_tool('build_patch.exe')
cginfo = lambda: _exec_tool('cginfo.exe')
check_adler = lambda: _exec_tool('check_adler.exe')
check_crc = lambda: _exec_tool('check_crc.exe')
check_md5 = lambda: _exec_tool('check_md5.exe')
dae2egg = lambda: _exec_tool('dae2egg.exe')
deploy_stub = lambda: _exec_tool('deploy-stub.exe')
deploy_stubw = lambda: _exec_tool('deploy-stubw.exe')
dxf_points = lambda: _exec_tool('dxf-points.exe')
dxf2egg = lambda: _exec_tool('dxf2egg.exe')
egg_crop = lambda: _exec_tool('egg-crop.exe')
egg_list_textures = lambda: _exec_tool('egg-list-textures.exe')
egg_make_tube = lambda: _exec_tool('egg-make-tube.exe')
egg_mkfont = lambda: _exec_tool('egg-mkfont.exe')
egg_optchar = lambda: _exec_tool('egg-optchar.exe')
egg_palettize = lambda: _exec_tool('egg-palettize.exe')
egg_qtess = lambda: _exec_tool('egg-qtess.exe')
egg_rename = lambda: _exec_tool('egg-rename.exe')
egg_retarget_anim = lambda: _exec_tool('egg-retarget-anim.exe')
egg_texture_cards = lambda: _exec_tool('egg-texture-cards.exe')
egg_topstrip = lambda: _exec_tool('egg-topstrip.exe')
egg_trans = lambda: _exec_tool('egg-trans.exe')
egg2bam = lambda: _exec_tool('egg2bam.exe')
egg2c = lambda: _exec_tool('egg2c.exe')
egg2dxf = lambda: _exec_tool('egg2dxf.exe')
egg2flt = lambda: _exec_tool('egg2flt.exe')
egg2maya2008 = lambda: _exec_tool('egg2maya2008.exe')
egg2maya2009 = lambda: _exec_tool('egg2maya2009.exe')
egg2maya2011 = lambda: _exec_tool('egg2maya2011.exe')
egg2maya2012 = lambda: _exec_tool('egg2maya2012.exe')
egg2maya2013 = lambda: _exec_tool('egg2maya2013.exe')
egg2maya2014 = lambda: _exec_tool('egg2maya2014.exe')
egg2maya2015 = lambda: _exec_tool('egg2maya2015.exe')
egg2maya2016 = lambda: _exec_tool('egg2maya2016.exe')
egg2maya20165 = lambda: _exec_tool('egg2maya20165.exe')
egg2maya2017 = lambda: _exec_tool('egg2maya2017.exe')
egg2maya2018 = lambda: _exec_tool('egg2maya2018.exe')
egg2maya2019 = lambda: _exec_tool('egg2maya2019.exe')
egg2maya2020 = lambda: _exec_tool('egg2maya2020.exe')
egg2maya85 = lambda: _exec_tool('egg2maya85.exe')
egg2obj = lambda: _exec_tool('egg2obj.exe')
egg2x = lambda: _exec_tool('egg2x.exe')
ffmpeg = lambda: _exec_tool('ffmpeg.exe')
ffplay = lambda: _exec_tool('ffplay.exe')
ffprobe = lambda: _exec_tool('ffprobe.exe')
flt_info = lambda: _exec_tool('flt-info.exe')
flt_trans = lambda: _exec_tool('flt-trans.exe')
flt2egg = lambda: _exec_tool('flt2egg.exe')
fltcopy = lambda: _exec_tool('fltcopy.exe')
image_info = lambda: _exec_tool('image-info.exe')
image_resize = lambda: _exec_tool('image-resize.exe')
image_trans = lambda: _exec_tool('image-trans.exe')
interrogate = lambda: _exec_tool('interrogate.exe')
interrogate_module = lambda: _exec_tool('interrogate_module.exe')
lwo_scan = lambda: _exec_tool('lwo-scan.exe')
lwo2egg = lambda: _exec_tool('lwo2egg.exe')
make_prc_key = lambda: _exec_tool('make-prc-key.exe')
maya2egg2008 = lambda: _exec_tool('maya2egg2008.exe')
maya2egg2009 = lambda: _exec_tool('maya2egg2009.exe')
maya2egg2011 = lambda: _exec_tool('maya2egg2011.exe')
maya2egg2012 = lambda: _exec_tool('maya2egg2012.exe')
maya2egg2013 = lambda: _exec_tool('maya2egg2013.exe')
maya2egg2014 = lambda: _exec_tool('maya2egg2014.exe')
maya2egg2015 = lambda: _exec_tool('maya2egg2015.exe')
maya2egg2016 = lambda: _exec_tool('maya2egg2016.exe')
maya2egg20165 = lambda: _exec_tool('maya2egg20165.exe')
maya2egg2017 = lambda: _exec_tool('maya2egg2017.exe')
maya2egg2018 = lambda: _exec_tool('maya2egg2018.exe')
maya2egg2019 = lambda: _exec_tool('maya2egg2019.exe')
maya2egg2020 = lambda: _exec_tool('maya2egg2020.exe')
maya2egg85 = lambda: _exec_tool('maya2egg85.exe')
mayacopy2008 = lambda: _exec_tool('mayacopy2008.exe')
mayacopy2009 = lambda: _exec_tool('mayacopy2009.exe')
mayacopy2011 = lambda: _exec_tool('mayacopy2011.exe')
mayacopy2012 = lambda: _exec_tool('mayacopy2012.exe')
mayacopy2013 = lambda: _exec_tool('mayacopy2013.exe')
mayacopy2014 = lambda: _exec_tool('mayacopy2014.exe')
mayacopy2015 = lambda: _exec_tool('mayacopy2015.exe')
mayacopy2016 = lambda: _exec_tool('mayacopy2016.exe')
mayacopy20165 = lambda: _exec_tool('mayacopy20165.exe')
mayacopy2017 = lambda: _exec_tool('mayacopy2017.exe')
mayacopy2018 = lambda: _exec_tool('mayacopy2018.exe')
mayacopy2019 = lambda: _exec_tool('mayacopy2019.exe')
mayacopy2020 = lambda: _exec_tool('mayacopy2020.exe')
mayacopy85 = lambda: _exec_tool('mayacopy85.exe')
multify = lambda: _exec_tool('multify.exe')
obj2egg = lambda: _exec_tool('obj2egg.exe')
p3dcparse = lambda: _exec_tool('p3dcparse.exe')
parse_file = lambda: _exec_tool('parse_file.exe')
pdecrypt = lambda: _exec_tool('pdecrypt.exe')
pencrypt = lambda: _exec_tool('pencrypt.exe')
pfm_bba = lambda: _exec_tool('pfm-bba.exe')
pfm_trans = lambda: _exec_tool('pfm-trans.exe')
pstats = lambda: _exec_tool('pstats.exe')
punzip = lambda: _exec_tool('punzip.exe')
pview = lambda: _exec_tool('pview.exe')
pzip = lambda: _exec_tool('pzip.exe')
show_ddb = lambda: _exec_tool('show_ddb.exe')
test_interrogate = lambda: _exec_tool('test_interrogate.exe')
text_stats = lambda: _exec_tool('text-stats.exe')
vrml_trans = lambda: _exec_tool('vrml-trans.exe')
vrml2egg = lambda: _exec_tool('vrml2egg.exe')
x_trans = lambda: _exec_tool('x-trans.exe')
x2egg = lambda: _exec_tool('x2egg.exe')

